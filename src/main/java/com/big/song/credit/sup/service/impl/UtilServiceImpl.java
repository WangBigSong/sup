package com.big.song.credit.sup.service.impl;

import com.big.song.credit.sup.entity.dto.RequestDTO;
import com.big.song.credit.sup.service.UtilService;
import com.big.song.credit.sup.util.ChangeTXTName;
import com.big.song.credit.sup.util.MakeDeleteTXT;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {



    @Override
    public void createDeleteTXT(RequestDTO requestDTO) {
        new MakeDeleteTXT().makeDeleteXMl(requestDTO.getPath(),requestDTO.getType(),requestDTO.getOrgCode());
    }

    @Override
    public void changeTXTName(RequestDTO requestDTO) {
        new ChangeTXTName().creditNewTXTName(requestDTO.getPath());
    }
}
