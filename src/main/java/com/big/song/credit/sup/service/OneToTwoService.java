package com.big.song.credit.sup.service;

public interface OneToTwoService {

    /***
     * 追加授信段信息
     * @param inPath
     * @param orgCode
     * @param type
     */
    void addCreditNode(String inPath,String orgCode,Integer type);


    /***
     * 追加借贷基础概括
     * @param inPath
     * @param orgCode
     * @param type
     */
    void addAcctBsInfSgmt(String inPath,String orgCode,Integer type );

    /***
     * 通过反馈文件，整理SQL脚本
     * @param inPath
     * @param orgCode
     * @param type
     */
    void readFBTXTReturnDelSql(String inPath,String orgCode,Integer type );
}
