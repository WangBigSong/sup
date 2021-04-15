package com.big.song.credit.sup.service;

import com.big.song.credit.sup.entity.dto.RequestDTO;

public interface UtilService {
    /***
     * 生成删除报文
     */
    void createDeleteTXT(RequestDTO requestDTO);

    /***
     * 修改报文名
     */
    void changeTXTName(RequestDTO requestDTO);


}
