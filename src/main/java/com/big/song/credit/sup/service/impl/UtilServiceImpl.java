package com.big.song.credit.sup.service.impl;

import com.big.song.credit.sup.constant.CreditCode;
import com.big.song.credit.sup.dao.TpblAcctCredSgmt;
import com.big.song.credit.sup.dao.TpblAcctCredSgmtExample;
import com.big.song.credit.sup.mapper.TpblAcctCredSgmtMapper;
import com.big.song.credit.sup.service.UtilService;
import com.big.song.credit.sup.util.ChangeTXTName;
import com.big.song.credit.sup.util.MakeDeleteTXT;
import com.big.song.credit.sup.util.TxtFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class UtilServiceImpl implements UtilService {



    @Override
    public void createDeleteTXT(String inPath,String orgOcde,Integer deleteCode) {
        new MakeDeleteTXT().makeDeleteXMl(inPath,deleteCode,orgOcde);
    }

    @Override
    public void changeTXTName(String inPath, String newTime) {
        new ChangeTXTName().creditNewTXTName(inPath ,newTime);
    }


}
