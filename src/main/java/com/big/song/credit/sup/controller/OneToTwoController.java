package com.big.song.credit.sup.controller;

import com.big.song.credit.sup.entity.dto.RequestDTO;
import com.big.song.credit.sup.entity.dto.WebResponse;
import com.big.song.credit.sup.service.OneToTwoService;
import com.big.song.credit.sup.util.WebResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

/***
 * 一二代切换用
 */
@Api(value="一二代切换用",tags={"一二代切换用"})
@RestController
@RequestMapping("/big/two")
public class OneToTwoController {

    @Autowired
    private OneToTwoService oneToTwoService;

    @ApiOperation(value="个人借贷标识变更",notes="一二代续报时，借贷个人标识变更")
    @PostMapping("/pl-sign-change")
    public WebResponse changePersonLoanSige(@RequestBody RequestDTO requestDTO){
       boolean result= oneToTwoService.changePersonLoanSige(requestDTO);
       if(result){
           return WebResponseUtil.returnSucc("操作已完成");
       }
           return WebResponseUtil.returnSucc("操作失败");
    }

    @ApiOperation(value="追加借贷授信段",notes="一二代续报时，反馈账户类型不匹配问题，追加授信额度段，修改借贷账户为R4，需要配置数据库连接信息，只处理反馈报文中错误类型为AcctType的数据")
    @PostMapping("/add-pl-credit-node")
    @Async
    public void addCreditNodeToXML(@RequestBody RequestDTO requestDTO){
         oneToTwoService.addCreditNode(requestDTO);
    }

    @ApiOperation(value="追加借贷基础信息",notes="一二代续报时，提示缺少借贷基础段，需要配置数据库连接信息")
    @PostMapping("/add-pl-acctbsinfo")
    @Async
    public void addAcctBsInfSgmtToXML(@RequestBody RequestDTO requestDTO){
        oneToTwoService.addAcctBsInfSgmt(requestDTO);
    }

    @ApiOperation(value="反馈报文",notes="针对人行反馈文件，进行解析，生成删除历史表记录和修改业务表状态的SQL")
    @PostMapping("/fb")
    public void readFBTXTReturnDelSql(@RequestBody RequestDTO requestDTO){
        oneToTwoService.readFBTXTReturnDelSql(requestDTO);
    }
}
