package com.big.song.credit.sup.controller;

import com.big.song.credit.sup.entity.dto.RequestDTO;
import com.big.song.credit.sup.service.UtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/del")
    public void createDeleteTXT(@RequestBody RequestDTO requestDTO){
        utilService.createDeleteTXT(requestDTO);
    }

    @ApiOperation(value="重新生成报文名",notes="重新生成报文名")
    @PostMapping("/change-name")
    public void changeTXTName(@RequestBody RequestDTO requestDTO){
        utilService.changeTXTName(requestDTO);
    }
}
