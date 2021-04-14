package com.big.song.credit.sup.util;

import com.big.song.credit.sup.constant.CreditCode;
import java.io.*;
import java.util.*;

public class MakeDeleteTXT {

    /***
     * 获取需要制作整比删除报文的报文路径
     * @param inPath
     * @param deleteCode
     */
    public  void makeDeleteXMl(String inPath,Integer deleteCode,String orgOcde){
        // 读取所有的txt报文
        List<String> path = TxtFileUtil.getInstance().getTXTListInPath(inPath);
        System.out.println("总共读取："+path.size()+" 份报文");

        Set<String> delXML = new HashSet<>();
        // 遍历所有的报文，取出业务号等相关内容，并组成删除报文
        for(String fileName : path){
            System.out.println(">>>>文件名：" + fileName);
            // 获取所有的业务号
            List<Map<String,String>> acctCodeList = readLineVarFile(deleteCode,fileName, 1);
            // 准备按删除报文
            Map<String,String> xmlMap = TxtFileUtil.getInstance().readlyDELXMLCont(deleteCode,acctCodeList,orgOcde);
            // 去重
            String[] xmlArr = xmlMap.get("cont").split("\n");
            for(String temp : xmlArr){
                delXML.add(temp);
            }
        }
        // 报文头
        String headCont = TxtFileUtil.getInstance().writeHeadCont(delXML.size(),deleteCode,orgOcde);
        List<String> delXMLList = new ArrayList<>(delXML);
        // 将报文头插入到第一的位置
        delXMLList.add(0,headCont);
        // 写报文
        TxtFileUtil.getInstance().createXMLAndWriteCont(inPath,deleteCode,delXMLList,orgOcde,CreditCode.END,CreditCode.FILE_TXT);
    }

    /***
     * 读取文件内容
     * @param fileName
     * @param lineNumber
     * @return
     * @throws IOException
     */
    public List<Map<String,String>> readLineVarFile(Integer deleteCode,String fileName, int lineNumber) {
        File file = new File(fileName);
        List<Map<String,String>> contMap = new ArrayList<>();
        //判断文件存在并且是文件
        Boolean boo = file.exists() && file.isFile();
        if (boo) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String lineTxt ;
                int count=1;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    // 第一行的内容不读取
                    if(count == lineNumber){
                        count++;
                        continue;
                    }
                    // 从人行反馈报文中的获取信息
                    if(lineTxt.indexOf("原出错记录")>0){
                        String[]  contArr = lineTxt.split("原出错记录：");
                        String[]  typeArr = contArr[0].split("反馈消息：")[1].split("消息内容：");
                        contMap.add(TxtFileUtil.getInstance().getXMLUniqueInfoWithCode(deleteCode,typeArr[0],contArr[contArr.length-1]));
                    }else{
                        // 从正常报文中获取信息
                        contMap.add(TxtFileUtil.getInstance().getXMLUniqueInfoWithCode(deleteCode,"原文",lineTxt));
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
        return  contMap;
    }

}
