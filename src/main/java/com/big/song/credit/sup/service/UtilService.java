package com.big.song.credit.sup.service;

public interface UtilService {
    /***
     * 生成删除报文
     * @param inPath
     * @param orgOcde
     * @return
     */
    void createDeleteTXT(String inPath,String orgOcde,Integer deleteCode);

    /***
     * 修改报文名
     * @param inPath
     * @param newTime
     */
    void changeTXTName(String inPath,String newTime);


}
