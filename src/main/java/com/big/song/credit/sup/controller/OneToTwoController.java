package com.big.song.credit.sup.controller;

import com.big.song.credit.sup.service.OneToTwoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 一二代切换用
 */
@Api(value="一二代切换用",tags={"一二代切换用"})
@RestController
@RequestMapping("/big/two")
public class OneToTwoController {

    @Autowired
    private OneToTwoService oneToTwoService;

    @ApiOperation(value="追加借贷授信段",notes="一二代续报时，反馈账户类型不匹配问题，追加授信额度段，修改借贷账户为R4，需要配置数据库连接信息")
    @GetMapping("/addCreditNode")
    @Async
    public void addCreditNodeToXML(@ApiParam(name="path",value="报文路径",required=true) String path,
                                   @ApiParam(name="orgCode",value="机构码",required=true)String orgCode){
         oneToTwoService.addCreditNode(path,orgCode,210);
    }

    @ApiOperation(value="追加借贷基础信息",notes="一二代续报时，提示缺少借贷基础段，需要配置数据库连接信息")
    @GetMapping("/addAcctBsInfSgmt")
    @Async
    public void addAcctBsInfSgmtToXML(@ApiParam(name="path",value="报文路径",required=true) String path,
                                      @ApiParam(name="orgCode",value="机构码",required=true)String orgCode){
        oneToTwoService.addAcctBsInfSgmt(path,orgCode,210);
    }

    @ApiOperation(value="反馈报文",notes="针对人行反馈文件，进行解析，生成删除历史表记录和修改业务表状态的SQL")
    @GetMapping("/fb")
    public void readFBTXTReturnDelSql(@ApiParam(name="path",value="报文路径",required=true) String path,
                                      @ApiParam(name="orgCode",value="机构码",required=true)String orgCode,
                                      @ApiParam(name="type",value="报文类型（企业暂不支持）",required=true)Integer type){
        oneToTwoService.readFBTXTReturnDelSql(path,orgCode,type);
    }
}
