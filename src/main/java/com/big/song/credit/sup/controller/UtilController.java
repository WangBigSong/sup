package com.big.song.credit.sup.controller;

import com.big.song.credit.sup.service.UtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 工具 改文件名，整笔删除报文
 */
@Api(value="工具类",tags={"工具类"})
@RestController
@RequestMapping("/big/util")
public class UtilController {

    @Autowired
    private UtilService utilService;

    @ApiOperation(value="生成整笔删除报文",notes="生成整笔删除报文")
    @GetMapping("/deleteTXT")
    @Async
    public void createDeleteTXT(
            @ApiParam(name="inPath",value="报文路径",required=true)String inPath,
            @ApiParam(name="orgOcde",value="机构码",required=true)String orgOcde,
            @ApiParam(name="deleteCode",value="删除报文编码（ps：借贷 214，个人114）",required=true)Integer deleteCode){
        utilService.createDeleteTXT(inPath,orgOcde,deleteCode);
    }

    @ApiOperation(value="重新生成报文名",notes="重新生成报文名")
    @GetMapping("/changeTXTName")
    @Async
    public void changeTXTName(
            @ApiParam(name="path",value="报文路径",required=true) String path,
            @ApiParam(name="newTime",value="新生成时间 YYYYMMDD",required=true)String newTime){
        utilService.changeTXTName(path,newTime);
    }
}
