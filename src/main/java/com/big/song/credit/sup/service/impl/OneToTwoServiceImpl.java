package com.big.song.credit.sup.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.big.song.credit.sup.constant.CreditCode;
import com.big.song.credit.sup.entity.dto.RequestDTO;
import com.big.song.credit.sup.entity.dto.WebResponse;
import com.big.song.credit.sup.entity.po.TpelAcctBsInfSgmt;
import com.big.song.credit.sup.entity.po.TpelAcctBsInfSgmtExample;
import com.big.song.credit.sup.entity.po.TpelAcctCredSgmt;
import com.big.song.credit.sup.entity.po.TpelAcctCredSgmtExample;
import com.big.song.credit.sup.mapper.TpelAcctBsInfSgmtMapper;
import com.big.song.credit.sup.mapper.TpelAcctCredSgmtMapper;
import com.big.song.credit.sup.service.OneToTwoService;
import com.big.song.credit.sup.util.TxtFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OneToTwoServiceImpl implements OneToTwoService {

    @Autowired
    private TpelAcctCredSgmtMapper tpelAcctCredSgmtMapper;

    @Autowired
    private TpelAcctBsInfSgmtMapper tpelAcctBsInfSgmtMapper;



    @Override
    public void addCreditNode(RequestDTO requestDTO) {
        // 获取合同号，查询授信信息，将授信段组装进去
        List<String> pathList = TxtFileUtil.getInstance().getTXTListInPath(requestDTO.getPath());
        Integer fileSize = 1;
        String txtEnd;
        List noCredt = new ArrayList<>();
        for (String eachPath : pathList){
            System.out.println(">>>>文件名：" + eachPath);
            // 得到追加了授信段的报文
            Map<String,List<String>> value = readTXTAndAddCreditNode(eachPath,requestDTO.getOrgCode());
            List<String> xmlContList = value.get("xmlCont");
            noCredt.add(String.join("\n",value.get("noCredt")));
            // 组装新的报文头
            String txtHeader = TxtFileUtil.getInstance().writeHeadCont(xmlContList.size(),CreditCode.PERSON_LOAN_CODE,requestDTO.getOrgCode());
            // 将报文头插入到第一行
            xmlContList.add(0,txtHeader);
            if(fileSize < 10){
                txtEnd = "000" + fileSize + "0";
            } else{
                txtEnd =  "00" + fileSize + "0";
            }
            // 创建新的报文并写入报文内容
            TxtFileUtil.getInstance().createXMLAndWriteCont(requestDTO.getPath(),
                                                            CreditCode.PERSON_LOAN_CODE,
                                                            xmlContList,
                                                            requestDTO.getOrgCode(),
                                                            txtEnd,
                                                            CreditCode.FILE_TXT);
            fileSize = fileSize + 1;
        }
         // 将未获取到授信的信息记录
        TxtFileUtil.getInstance().createXMLAndWriteCont(requestDTO.getPath()+File.separator+CreditCode.NEW_FILE_NO_CREDIT,
                                                            CreditCode.PERSON_LOAN_CODE,
                                                            noCredt,
                                                            requestDTO.getOrgCode(),
                                                            CreditCode.END,
                                                            CreditCode.FILE_TXT);
    }

    /****
     * 获取报文内容，并追加授信段
     * @param path
     * @param orgCode
     * @return
     */
    private Map<String,List<String>> readTXTAndAddCreditNode(String path,String orgCode){
        Map<String,List<String>> returnMap = new TreeMap<>();
        List<String> contList = new ArrayList<>();
        List<String> notHaveAcctCred = new ArrayList<>();
        List<String> otherError = new ArrayList<>();
        File file = new File(path);
        Boolean boo = file.exists() && file.isFile();
        if (boo) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String lineTxt ;
                int count=1; // 第一行的内容不读取
                while ((lineTxt = bufferedReader.readLine()) != null ) {
                    if(count == 1){
                        count ++;
                        continue;
                    }
                    // 为 1 表示为错误反馈文件，需要从反馈内容中将原报文拆分取出
                    if(lineTxt.indexOf("原出错记录：")>0){
                        // 确定错误类型
                        String[] contArr = lineTxt.split("原出错记录：");
                        String[] typeArr = contArr[0].split("反馈消息：")[1].split("消息内容：");
                        // 只将账户类型不匹配的数据 进行收集，其余错误不处理
                        if("AcctType".equals(typeArr[0].trim())){
                            lineTxt = contArr[1];
                            // 从报文中的合同信息
                            Map<String,String> contMap = TxtFileUtil.getInstance().getXMLUniqueInfoWithCode(CreditCode.PERSON_LOAN_CODE,"原文",lineTxt);
                            String acctCode = contMap.get("acctCode");
                            // 查库 获取借贷对应的授信信息
                            // System.out.println(">>>>>>>>:"+acctCode);
                            TpelAcctCredSgmtExample example = new TpelAcctCredSgmtExample();
                            TpelAcctCredSgmtExample.Criteria criteria = example.createCriteria();
                            criteria.andAcctNoEqualTo(acctCode.replace(orgCode,""));
                            List<TpelAcctCredSgmt>   tpelAcctCredSgmtList = tpelAcctCredSgmtMapper.selectByExample(example);
                            // 修改账户类型
                            lineTxt = lineTxt.replace("D1","R4");
                            if(tpelAcctCredSgmtList.size()>0){
                                // 添加授信标签
                                lineTxt = lineTxt.replace("<AcctMthlyBlgInfSgmt>",CreditCode.CREDIT_NODE.replace("#{mcc}",tpelAcctCredSgmtList.get(0).getCreditNo())+"<AcctMthlyBlgInfSgmt>")   ;
                            } else {
                                notHaveAcctCred.add(acctCode.replace(orgCode,""));
                                lineTxt = lineTxt.replace("<AcctMthlyBlgInfSgmt>",CreditCode.CREDIT_NODE.replace("#{mcc}","**********")+"<AcctMthlyBlgInfSgmt>")   ;
                            }
                        }
                        contList.add(lineTxt);
                    }
                    count++;
                }
                // 查询到授信的数据之后，追加了授信段内容的报文
                returnMap.put("xmlCont",contList);
                // 未查询到授信的合同号
                returnMap.put("noCredt",notHaveAcctCred);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return returnMap;
    }


    @Override
    public void addAcctBsInfSgmt(RequestDTO requestDTO) {
        // 获取合同号，查询借贷概括信息
        List<String> pathList = TxtFileUtil.getInstance().getTXTListInPath(requestDTO.getPath());
        Integer fileSize = 1;
        String txtEnd;
        List noAcctBsInf = new ArrayList<>();
        for ( String path : pathList ) {
            System.out.println(">>>>文件名：" + path);
            // 追加借贷基础信息段
            Map<String,List<String>> value = readTXTAndAddAcctBsInfSgmtNode(path,requestDTO.getOrgCode());
            List<String> xmlContList = value.get("xmlCont");
            noAcctBsInf.add(String.join("\n",value.get("noAcctBsInf")));
            String txtHeader = TxtFileUtil.getInstance().writeHeadCont(xmlContList.size(),CreditCode.PERSON_LOAN_CODE,requestDTO.getOrgCode());
            xmlContList.add(0,txtHeader);
            if(fileSize < 10){
                txtEnd = "000" + fileSize + "0";
            } else{
                txtEnd =  "00" + fileSize + "0";
            }
            TxtFileUtil.getInstance().createXMLAndWriteCont(requestDTO.getPath(),CreditCode.PERSON_LOAN_CODE,xmlContList,requestDTO.getOrgCode(),txtEnd,CreditCode.FILE_TXT);
            fileSize = fileSize + 1;
        }
        TxtFileUtil.getInstance().createXMLAndWriteCont(requestDTO.getPath()+File.separator+CreditCode.NEW_FILE_NO_ACCT_BS_INF,CreditCode.PERSON_LOAN_CODE,noAcctBsInf,requestDTO.getOrgCode(),CreditCode.END,CreditCode.FILE_TXT);
    }


    private Map<String,List<String>> readTXTAndAddAcctBsInfSgmtNode(String path,String orgCode){
        Map<String,List<String>> returnMap = new TreeMap<>();
        List<String> contList = new ArrayList<>();
        List<String> notHaveAcctBsInf = new ArrayList<>();
        File file = new File(path);
        Boolean boo = file.exists() && file.isFile();
        if (boo) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String lineTxt ;
                int count=1;   // 第一行的内容不读取
                while ((lineTxt = bufferedReader.readLine()) != null ) {
                    if(count == 1){
                        count ++;
                        continue;
                    }
                    // 判断是否不存在基础信息概括段的内容
                    if(lineTxt.indexOf("<AcctBsInfSgmt>") <= 0){
                        // 从报文中获取信息
                        Map<String,String> contMap = TxtFileUtil.getInstance().getXMLUniqueInfoWithCode(CreditCode.PERSON_LOAN_CODE,"原文",lineTxt);
                        String acctCode = contMap.get("acctCode");
                        // 查库 获取借贷对应的授信信息
                        // System.out.println(">>>>>>>>:"+acctCode);

                        TpelAcctBsInfSgmtExample example = new TpelAcctBsInfSgmtExample();
                        TpelAcctBsInfSgmtExample.Criteria criteria = example.createCriteria();
                        criteria.andAcctNoEqualTo(acctCode.replace(orgCode,""));
                        List<TpelAcctBsInfSgmt> tpelAcctBsInfSgmtList = tpelAcctBsInfSgmtMapper.selectByExample(example);

                        if(tpelAcctBsInfSgmtList.size()>0){
                            String cont = replaceAcctBsInfSgmt(tpelAcctBsInfSgmtList.get(0));
                            lineTxt = lineTxt.replace("</AcctBsSgmt>","</AcctBsSgmt>"+cont)   ;
                        } else {
                            notHaveAcctBsInf.add(acctCode.replace(orgCode,""));
                        }
                    }
                    contList.add(lineTxt);
                    count++;
                }
                // 查询到授信的数据之后，追加了授信段内容的报文
                returnMap.put("xmlCont",contList);
                // 未查询到借贷基础信息的合同号
                returnMap.put("noAcctBsInf",notHaveAcctBsInf);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return returnMap;
    }


    /***
     * 替换借贷概括信息
     * @param tpelAcctBsInfSgmt
     * @return
     */
    private String replaceAcctBsInfSgmt(TpelAcctBsInfSgmt tpelAcctBsInfSgmt){
        String cont = CreditCode.ACCT_BS_INF_SGMT_NODE;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cont = cont.replace("#{BusiLines}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getBusiLines())?"":tpelAcctBsInfSgmt.getBusiLines());
        cont = cont.replace("#{BusiDtlLines}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getBusiDtlLines())?"":tpelAcctBsInfSgmt.getBusiDtlLines());
        cont = cont.replace("#{OpenDate}",StringUtils.isEmpty(sdf.format(tpelAcctBsInfSgmt.getOpenDate()))?"":sdf.format(tpelAcctBsInfSgmt.getOpenDate()));
        cont = cont.replace("#{Cy}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getCy())?"":tpelAcctBsInfSgmt.getCy());
        cont = cont.replace("#{LoanAmt}",StringUtils.isEmpty(String.valueOf(tpelAcctBsInfSgmt.getLoanAmt()))?"":String.valueOf(tpelAcctBsInfSgmt.getLoanAmt()));
        cont = cont.replace("#{Flag}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getFlag())?"0":tpelAcctBsInfSgmt.getFlag());
        cont = cont.replace("#{DueDate}",StringUtils.isEmpty(sdf.format(tpelAcctBsInfSgmt.getDueDate()))?"":sdf.format(tpelAcctBsInfSgmt.getDueDate()));
        cont = cont.replace("#{RepayMode}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getRepayMode())?"":tpelAcctBsInfSgmt.getRepayMode());
        cont = cont.replace("#{RepayFreqcy}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getRepayFreqcy())?"":tpelAcctBsInfSgmt.getRepayFreqcy());
        cont = cont.replace("#{RepayPrd}",StringUtils.isEmpty(String.valueOf(tpelAcctBsInfSgmt.getRepayPrd()))?"":String.valueOf(tpelAcctBsInfSgmt.getRepayPrd()));
        cont = cont.replace("#{ApplyBusiDist}", StringUtils.isEmpty(tpelAcctBsInfSgmt.getApplyBusiDist())?"":tpelAcctBsInfSgmt.getApplyBusiDist());
        cont = cont.replace("#{GuarMode}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getGuarMode())?"":tpelAcctBsInfSgmt.getGuarMode());
        cont = cont.replace("#{OthRepyGuarWay}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getOthRepyGuarWay())?"":tpelAcctBsInfSgmt.getOthRepyGuarWay());
        cont = cont.replace("#{AssetTrandFlag}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getAssetTrandFlag())?"":tpelAcctBsInfSgmt.getAssetTrandFlag());
        cont = cont.replace("#{FundSou}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getFundSou())?"":tpelAcctBsInfSgmt.getFundSou());
        cont = cont.replace("#{LoanForm}",StringUtils.isEmpty(tpelAcctBsInfSgmt.getLoanForm())?"":tpelAcctBsInfSgmt.getLoanForm());
        cont = cont.replace("null","");
        return cont;
    }


    @Override
    public void readFBTXTReturnDelSql(RequestDTO requestDTO) {
        // 获取合同号，查询借贷概括信息
        List<String> pathList = TxtFileUtil.getInstance().getTXTListInPath(requestDTO.getPath());
        for ( String path : pathList ) {
            System.out.println(">>>>文件名：" + path);
            List<String> sqlList = readFBTXTAndGetSQL(path,requestDTO.getOrgCode(),requestDTO.getType());
            TxtFileUtil.getInstance().createXMLAndWriteCont(requestDTO.getPath(),requestDTO.getType(),sqlList,requestDTO.getOrgCode(),"001",CreditCode.FILE_SQL);
        }
    }

    /***
     * 读取反馈文件，返回删除历史表的SQL
     * @param path
     * @param orgCode
     * @return
     */
    private List<String> readFBTXTAndGetSQL(String path,String orgCode,Integer type){
        List<String> contList = new ArrayList<>();
        File file = new File(path);
        Boolean boo = file.exists() && file.isFile();
        if (boo) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String lineTxt ;
                int count=1; // 第一行的内容不读取
                while ((lineTxt = bufferedReader.readLine()) != null ) {
                    if(count == 1){
                        count ++;
                        continue;
                    }
                    // 错误反馈文件，需要从反馈内容中将原报文拆分取出
                    if(lineTxt.indexOf("原出错记录：")>0){
                        // 确定错误类型
                        String[] contArr = lineTxt.split("原出错记录：");
                        lineTxt = contArr[1];
                        // 从报文中的合同信息
                        Map<String,String> contMap = TxtFileUtil.getInstance().getXMLUniqueInfoWithCode(type,"原文",lineTxt);
                        String delSql = TxtFileUtil.getInstance().getDelHisSQL(type,orgCode,contMap);
                        contList.add(delSql);
                    }
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return contList;
    }

    @Override
    public boolean changePersonLoanSige(RequestDTO requestDTO) {
        List<String> pathList = TxtFileUtil.getInstance().getTXTListInPath(requestDTO.getPath());
        for (int i=0;i< pathList.size();i++) {
            // 因为考虑到每行数据，用BufferedReader 比较方便
            BufferedReader br = null;
            BufferedWriter bw = null;
            try {
                br = new BufferedReader(new FileReader(pathList.get(i)));
                // 输出路径 新文件名需要30位长度
                // 文件名前 14 位是数据提供机构区段码，中间 8 位是
                // “YYYYMMDD”格式的报文生成日期，最后 8 位是文件序号，由用户自行编制，保证文件名全局内不能重复
                String num= i< 10 ? String.valueOf("0"+ i) : String.valueOf(i) ;
                bw = new BufferedWriter(new FileWriter(requestDTO.getPath()
                        + File.separator + requestDTO.getOrgCode()
                        + new SimpleDateFormat("YYYYMMddHHmmss").format(new Date())
                        + num
                        + CreditCode.FILE_TXT));
                String lineString =null;
                while (true) {
                    lineString = br.readLine();
                    if (lineString == null) {
                        break;
                    }else {
                        bw.write(CreditCode.PERSON_LOAN_CODE+","+lineString.replace(",","")+","+lineString); // 写入一行数据
                        bw.newLine(); // 另起一行
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    bw.close();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public boolean changeCompanyLoanSige(RequestDTO requestDTO) {
        // todo
        return false;
    }
}
