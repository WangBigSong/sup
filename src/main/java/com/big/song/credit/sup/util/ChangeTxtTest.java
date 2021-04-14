package com.big.song.credit.sup.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ChangeTxtTest {




//    public static void main(String[] args) {
//        String inPath = "C:\\Users\\thinkpad\\Desktop\\永辉小贷\\报文加载与反馈（清库后）\\一二代切换\\个人\\第二次加载\\提取错误报文\\20210303_analyze";
//        Integer type = 210;
//        String orgCode = "N10156530H0089";
//        // 读取所有的txt报文
//        List<String> path = TxtFileUtil.getFileList(inPath);
//        System.out.println("总共读取："+path.size()+" 份报文");
//
//        // 遍历所有的报文，取出业务号等相关内容，并组成删除报文
//        Integer fileSize = 1;
//        String txtEnd;
//        for(String fileName : path){
//            System.out.println(">>>>文件名：" + fileName);
//            // 获取所有的业务号
//            List<String> acctCodeList = readLineAndChangeValue(type,fileName, 1);
//            String txtHeader = TxtFileUtil.writeHeadCont(acctCodeList.size(),type,orgCode);
//            acctCodeList.add(0,txtHeader);
//            if(fileSize < 10){
//                txtEnd = "00" + fileSize + "0";
//            }else{
//                txtEnd =  "0" + fileSize + "0";
//            }
//            TxtFileUtil.writeBodyCont(inPath,type,acctCodeList,orgCode,txtEnd);
//            fileSize=fileSize + 1;
//        }
//    }
}
