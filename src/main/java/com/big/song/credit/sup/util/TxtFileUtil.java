package com.big.song.credit.sup.util;

import com.big.song.credit.sup.constant.CreditCode;
import com.big.song.credit.sup.dao.TpelAcctBsInfSgmt;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class TxtFileUtil {

    private static class SingletonHoler {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static TxtFileUtil instance = new TxtFileUtil();
    }

    private TxtFileUtil() {
    }

    public static TxtFileUtil getInstance() {
        return SingletonHoler.instance;
    }




    public  boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    /**
     * 删除目录及目录下的文件
     *
     * @param dir：要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public  boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }
    /***
     * 获取所有的报文路径
     * @param path
     * @return
     */
    public List<String> getTXTListInPath(String path) {
        File file = new File(path);
        File[] array = file.listFiles();
        List<String> txtPathList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                if(array[i].getPath().endsWith(".txt")){
                    txtPathList.add(array[i].getPath());
                }
            }else if (array[i].isDirectory()) {
                getTXTListInPath(array[i].getPath());
            }
        }
        return  txtPathList;
    }

    /***
     * 获取到xml中的唯一信息
     * @param code
     * @param acctType
     * @param xml
     * @return
     */
    public Map<String,String> getXMLUniqueInfoWithCode(Integer code, String acctType, String xml) {
        Document doc ;
        Map<String,String> contMap = new HashMap();
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点
            contMap.put("acctType",acctType);
            switch (code){
                case 110:
                case 114: // 个人基本信息
                    Element inBasInf = rootElt.element("InBasInf");
                     String personName = inBasInf.element("BsSgmt").element("Name").getText();
                     String idNUM = inBasInf.element("BsSgmt").element("IDNum").getText();
                    contMap.put("personName",personName);
                    contMap.put("IdNum",idNUM);
                    break;
                case 210:
                case 214:// 个人借贷
                    Element acctInf = rootElt.element("InAcctInf");
                     String acctCode = acctInf.element("AcctBsSgmt").element("AcctCode").getText();
                    contMap.put("acctCode",acctCode);
                    break;
                case 220:
                case 224:// 个人授信
                    Element inCtrctInf = rootElt.element("InCtrctInf");
                     String contractCode = inCtrctInf.element("CtrctBsSgmt").element("ContractCode").getText();
                    contMap.put("contractCode",contractCode);
                    break;
                case 310:
                case 314: // 企业基本信息
                    Element enBasInf = rootElt.element("EnBasInf");
                     String entName = enBasInf.element("BsSgmt").element("EntName").getText();
                     String entCertNum = enBasInf.element("BsSgmt").element("EntCertNum").getText();
                    contMap.put("entName",entName);
                    contMap.put("entCertNum",entCertNum);
                    break;
                case 410:
                case 414: // 企业借贷
                    Element enAcctInf = rootElt.element("EnAcctInf");
                     String enAcctCode = enAcctInf.element("AcctBsSgmt").element("AcctCode").getText();
                    contMap.put("enAcctCode",enAcctCode);
                    break;
                case 420:
                case 424: // 企业授信e
                    Element enCtrctInf = rootElt.element("EnCtrctInf");
                     String entContractCode = enCtrctInf.element("CtrctBsSgmt").element("ContractCode").getText();
                    contMap.put("entContractCode",entContractCode);
                    break;
                case 510:
                case 514: // 抵质押
                    Element motgaCltalCtrctInf = rootElt.element("MotgaCltalCtrctInf");
                     String ccCode = motgaCltalCtrctInf.element("MotgaCltalCtrctBsSgmt").element("CcCode").getText();
                    contMap.put("ccCode",ccCode);
                    break;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contMap;
    }

    /***
     * 准备删除报文
     * @param delCode
     * @param acctCodeList
     * @param orgOcde
     * @return
     */
    public Map<String,String> readlyDELXMLCont(Integer delCode, List<Map<String,String>> acctCodeList,String orgOcde){
        Set<String> contSet=new TreeSet<>();
        Map<String,String> returnMap=new TreeMap<>();
        switch (delCode){
            case 110:
            case 114:
                for (Map<String,String> acctCode:acctCodeList){
                    contSet.add(CreditCode.DEL_MODEL_PERSON_BASE
                            .replace("#{personName}",acctCode.get("personName"))
                            .replace("#{IdNUM}",acctCode.get("IdNum"))
                            .replace("#{ORGCODE}",orgOcde));
                }
                break;
            case 210:
            case 214:
                for (Map<String,String> acctCode:acctCodeList){
                    contSet.add(CreditCode.DEL_MODEL_PERSON_LOAN.replace("#{acctCode}",acctCode.get("acctCode")));
                }
                break;
            case 220:
            case 224:
                for (Map<String,String> acctCode:acctCodeList){
                    contSet.add(CreditCode.DEL_MODEL_PERSON_CREDIT
                            .replace("#{contractCode}",acctCode.get("contractCode")));
                }
                break;
            case 310:
            case 314:
                for (Map<String,String> acctCode:acctCodeList){
                    contSet.add(CreditCode.DEL_MODEL_COMPANY_BASE
                            .replace("#{entName}",acctCode.get("entName"))
                            .replace("#{entCertNum}",acctCode.get("entCertNum"))
                            .replace("#{ORGCODE}",orgOcde));
                }
                break;
            case 410:
            case 414:
                for (Map<String,String> acctCode:acctCodeList){
                    contSet.add(CreditCode.DEL_MODEL_COMPANY_LOAN.replace("#{enAcctCode}",acctCode.get("enAcctCode")));
                }
                break;
            case 420:
            case 424:
                for (Map<String,String> acctCode:acctCodeList){
                    contSet.add(CreditCode.DEL_MODEL_COMPANY_CREDIT.replace("#{entContractCode}",acctCode.get("entContractCode")));
                }
                break;
            case 510:
            case 514:
                for (Map<String,String> acctCode:acctCodeList){
                    contSet.add(CreditCode.DEL_MODEL_DIZITA.replace("#{ccCode}",acctCode.get("ccCode")));
                }
                break;
        }
        returnMap.put("size",String.valueOf(contSet.size()));
        returnMap.put("cont",String.join("", contSet));
        return returnMap;
    }


    /***
     * 组装报文头
     * @param xmlNUM 报文个数
     * @param type   类型
     * @param orgCode 机构码
     * @return
     */
    public  String writeHeadCont(long xmlNUM,Integer type,String orgCode) {
        String size = String.valueOf(xmlNUM);
        StringBuffer head = new StringBuffer(CreditCode.TXT_HEAD+type+"2.0.0  "+orgCode);
        head.append(new SimpleDateFormat("YYYYMMddHHmmss").format(new Date())+"0");
        head.append("0000000".substring(0,7 - size.length() ) + size);
        return head.toString();
    }

    /****
     * 写入报文
     * @param path 新报文地址
     * @param type 类型
     * @param cont 内容
     * @param orgCode 机构码
     */
    public void createXMLAndWriteCont(String path,Integer type,List<String> cont,String orgCode,String txtEnd,String filetype) {
         FileWriter fw = null;
        PrintWriter pw = null;
        try {
            String txtName = orgCode + new SimpleDateFormat("YYYYMMdd").format(new Date())
                    + type + txtEnd + filetype ;
            File f = new File(path + File.separator + CreditCode.NEW_FILE_NAME);
            f.mkdirs();
            fw = new FileWriter(new File(f.getPath()+ File.separator +txtName), true);
            pw = new PrintWriter(fw);
            for(String arr : cont){
                // 一行一行的写进去
                pw.println(arr);
            }
            pw.flush();
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pw!=null){
                    pw.close();
                }
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /***
     * 删除历史记录，修改TB表状态
     * @param code
     * @param orgCode
     * @param uniqueMap
     * @return
     */
    public String getDelHisSQL(Integer code,String orgCode,Map<String,String> uniqueMap) {
        StringBuffer stringBuffer = new StringBuffer("-- 删除历史数据 \n");
            switch (code){
                case 110:
                case 114: // 个人基本信息
                     for(int i = 0 ; i<=CreditCode.PERSON_BASE_TH.length -1 ; i++){
                         String delSql = String.format("delete from %s where cust_id in(select cust_id from tpbb_bs_sgmt where id_num='%s' and name='%s');",
                                 CreditCode.PERSON_BASE_TH[i],uniqueMap.get("IdNum"),uniqueMap.get("personName"));
                         stringBuffer.append(delSql);
                     }
                    stringBuffer.append("-- 修改业务表表上传状态 \n");
                    for(int i = 0 ; i <= CreditCode.PERSON_BASE_TB.length -1 ; i++){
                        String delSql = String.format("UPDATE %s t1 set t1.stat='00' where id_num='%s' and name='%s';",
                                CreditCode.PERSON_BASE_TB[i],uniqueMap.get("IdNum"),uniqueMap.get("personName"));
                        stringBuffer.append(delSql);
                    }
                    break;
                case 210:
                case 214: // 个人借贷
                    for(int i = 0 ; i <= CreditCode.PERSON_LOAN_TH.length -1 ; i++){
                        String delSql = String.format("delete from %s where cust_id in(select cust_id from tpbl_acct_bs_sgmt where acct_no='%s');",
                                CreditCode.PERSON_LOAN_TH[i],uniqueMap.get("acctCode").replace(orgCode,""));
                        stringBuffer.append(delSql);
                    }
                    stringBuffer.append("-- 修改业务表表上传状态 \n");
                    for(int i = 0 ; i <= CreditCode.PERSON_LOAN_TB.length -1  ; i++){
                        String delSql = String.format("UPDATE %s t1 set t1.stat='00' where acct_no='%s';",
                                CreditCode.PERSON_LOAN_TB[i],uniqueMap.get("acctCode").replace(orgCode,""));
                        stringBuffer.append(delSql);
                    }
                    break;
                case 220:
                case 224: // 个人授信
                    for(int i = 0 ; i <= CreditCode.PERSON_CTRCT_TH.length -1 ; i++){
                        String delSql = String.format("delete from %s where cust_id in(select cust_id from tpbc_ctrct_bs_sgmt where credit_no='%s');",
                                CreditCode.PERSON_CTRCT_TH[i],uniqueMap.get("contractCode").replace(orgCode,""));
                        stringBuffer.append(delSql);
                    }
                    stringBuffer.append("-- 修改业务表表上传状态 \n");
                    for(int i = 0 ; i <= CreditCode.PERSON_CTRCT_TB.length -1 ; i++){
                        String delSql = String.format("UPDATE %s t1 set t1.stat='00' where credit_no='%s';",
                                CreditCode.PERSON_CTRCT_TB[i],uniqueMap.get("contractCode").replace(orgCode,""));
                        stringBuffer.append(delSql);
                    }
                    break;
                case 310:
                case 314: // 企业基本信息 todo
                    break;
                case 410:
                case 414: // 企业借贷 todo
                    break;
                case 420:
                case 424: // 企业授信 todo
                    break;
                case 510:
                case 514: // 抵质押 todo
                    break;
            }
        return stringBuffer.toString();
    }
}
