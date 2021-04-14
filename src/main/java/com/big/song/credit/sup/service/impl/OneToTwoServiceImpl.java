package com.big.song.credit.sup.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.big.song.credit.sup.constant.CreditCode;
import com.big.song.credit.sup.dao.*;
import com.big.song.credit.sup.mapper.TpblAcctCredSgmtMapper;
import com.big.song.credit.sup.mapper.TpecCtrctBsSgmtMapper;
import com.big.song.credit.sup.mapper.TpelAcctBsInfSgmtMapper;
import com.big.song.credit.sup.mapper.TpelAcctCredSgmtMapper;
import com.big.song.credit.sup.service.OneToTwoService;
import com.big.song.credit.sup.util.TxtFileUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class OneToTwoServiceImpl implements OneToTwoService {

    @Autowired
    private TpelAcctCredSgmtMapper tpelAcctCredSgmtMapper;

    @Autowired
    private TpelAcctBsInfSgmtMapper tpelAcctBsInfSgmtMapper;



    @Override
    public void addCreditNode(String filePath, String orgCode,Integer type) {
        // 获取合同号，查询授信信息，将授信段组装进去
        List<String> pathList = TxtFileUtil.getInstance().getTXTListInPath(filePath);
        Integer fileSize = 1;
        String txtEnd;
        List noCredt = new ArrayList<>();
        for (String eachPath : pathList){
            System.out.println(">>>>文件名：" + eachPath);
            // 得到追加了授信段的报文
            Map<String,List<String>> value = readTXTAndAddCreditNode(eachPath,orgCode);
            List<String> xmlContList = value.get("xmlCont");
            noCredt.add(String.join("\n",value.get("noCredt")));
            // 组装新的报文头
            String txtHeader = TxtFileUtil.getInstance().writeHeadCont(xmlContList.size(),type,orgCode);
            // 将报文头插入到第一行
            xmlContList.add(0,txtHeader);
            if(fileSize < 10){
                txtEnd = "000" + fileSize + "0";
            } else{
                txtEnd =  "00" + fileSize + "0";
            }
            // 创建新的报文并写入报文内容
            TxtFileUtil.getInstance().createXMLAndWriteCont(filePath,type,xmlContList,orgCode,txtEnd,CreditCode.FILE_TXT);
            fileSize = fileSize + 1;
        }
         // 将未获取到授信的信息记录
        TxtFileUtil.getInstance().createXMLAndWriteCont(filePath+File.separator+CreditCode.NEW_FILE_NO_CREDIT,type,noCredt,orgCode,CreditCode.END,CreditCode.FILE_TXT);
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
    public void addAcctBsInfSgmt(String filePath, String orgCode, Integer type) {
        // 获取合同号，查询借贷概括信息
        List<String> pathList = TxtFileUtil.getInstance().getTXTListInPath(filePath);
        Integer fileSize = 1;
        String txtEnd;
        List noAcctBsInf = new ArrayList<>();
        for ( String path : pathList ) {
            System.out.println(">>>>文件名：" + path);
            // 追加借贷基础信息段
            Map<String,List<String>> value = readTXTAndAddAcctBsInfSgmtNode(path,orgCode);
            List<String> xmlContList = value.get("xmlCont");
            noAcctBsInf.add(String.join("\n",value.get("noAcctBsInf")));
            String txtHeader = TxtFileUtil.getInstance().writeHeadCont(xmlContList.size(),type,orgCode);
            xmlContList.add(0,txtHeader);
            if(fileSize < 10){
                txtEnd = "000" + fileSize + "0";
            } else{
                txtEnd =  "00" + fileSize + "0";
            }
            TxtFileUtil.getInstance().createXMLAndWriteCont(filePath,type,xmlContList,orgCode,txtEnd,CreditCode.FILE_TXT);
            fileSize = fileSize + 1;
        }
        TxtFileUtil.getInstance().createXMLAndWriteCont(filePath+File.separator+CreditCode.NEW_FILE_NO_ACCT_BS_INF,type,noAcctBsInf,orgCode,CreditCode.END,CreditCode.FILE_TXT);
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
    public void readFBTXTReturnDelSql(String filePath, String orgCode, Integer type) {
        // 获取合同号，查询借贷概括信息
        List<String> pathList = TxtFileUtil.getInstance().getTXTListInPath(filePath);
        for ( String path : pathList ) {
            System.out.println(">>>>文件名：" + path);
            List<String> sqlList = readFBTXTAndGetSQL(path,orgCode,type);
            TxtFileUtil.getInstance().createXMLAndWriteCont(filePath,type,sqlList,orgCode,"001",CreditCode.FILE_SQL);
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
}
