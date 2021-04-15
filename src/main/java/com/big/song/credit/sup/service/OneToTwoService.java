package com.big.song.credit.sup.service;

import com.big.song.credit.sup.entity.dto.RequestDTO;

public interface OneToTwoService {

    /***
     * 追加授信段信息
     */
    void addCreditNode(RequestDTO requestDTO);

    /***
     * 追加借贷基础概括
     */
    void addAcctBsInfSgmt(RequestDTO requestDTO);

    /***
     * 通过反馈文件，整理SQL脚本
     */
    void readFBTXTReturnDelSql(RequestDTO requestDTO);

    /***
     * 个人借贷标识变更
     * @param requestDTO
     * @return
     */
    boolean changePersonLoanSige(RequestDTO requestDTO);

    /***
     * 企业借贷标识变更
     * @param requestDTO
     * @return
     */
    boolean changeCompanyLoanSige(RequestDTO requestDTO);
}
