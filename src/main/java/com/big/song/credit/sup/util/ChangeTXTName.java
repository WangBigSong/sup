package com.big.song.credit.sup.util;

import com.big.song.credit.sup.constant.CreditCode;

import java.io.*;
import java.util.*;

/***
 * 重新命名报文
 */
public class ChangeTXTName {

    /***
     * 写入内容
     * @param oldfilePath
     * @param newfilePath
     */
    public void writeContToNewTXT(String oldfilePath,String newfilePath,String newTime){
        File file = new File(oldfilePath);
        //判断文件存在并且是文件
        Boolean boo = file.exists() && file.isFile();
        if (boo) {
            BufferedReader bufferedReader = null;
            try {
                //构造一个BufferedReader类来读取文件
                bufferedReader = new BufferedReader(new FileReader(file));
                String linetxt ;
                //result用来存储文件内容
                StringBuilder result = new StringBuilder();
                //按使用readLine方法，一次读一行
                int count=1;
                while ((linetxt = bufferedReader.readLine()) != null) {
                    // 只改报文内容第一行的数据，将报文生成时间调整为新的时间
                    if(count==1){
                        linetxt = linetxt.substring(0,28)+newTime+linetxt.substring(36);
                    }
                    result.append(linetxt);
                    File newFile = new File(newfilePath);
                    PrintStream ps = new PrintStream(new FileOutputStream(newFile, true));
                    ps.println(linetxt);// 写入新内容
                    count++;
                }
            } catch (Exception e) {
                System.out.println("读取文件内容出错");
                e.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }else{
            System.out.println("找不到指定的文件");
        }
    }


    /***
     * 创建新的报文
     * @param path
     * @param newTime
     */
    public void creditNewTXTName(String path,String newTime){
        List<String> files = TxtFileUtil.getInstance().getTXTListInPath(path);
        int i=1;
        for (String filePath : files){
            File file = new File(filePath);
            if(!file.isDirectory()){
                String newName = file.getName().substring(0,14) + newTime + file.getName().substring(22,25) ;
                if(i<10){
                    newName = newName + "000" + i + "0.txt";
                }else{
                    newName = newName + "00"  + i + "0.txt";
                }
                i = i + 1;
                File newFileName = new File(file.getParent() + File.separator + CreditCode.NEW_FILE_NAME);
                 // 创建新报文的文件夹
                newFileName.mkdirs();
                 // 写入内容
                writeContToNewTXT(file.getAbsolutePath(),newFileName.getAbsolutePath() + File.separator+ newName,newTime);
            }
        }
    }
}
