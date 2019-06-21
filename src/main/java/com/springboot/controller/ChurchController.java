package com.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.common.CommonUtil;
import com.springboot.entity.Church;
import com.springboot.service.ChurchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Api(value = "团契操作", description = "团契相关的操作", tags = {"团契模块"})
@RestController
@RequestMapping("/church")
public class ChurchController {
    @Autowired
    private ChurchService churchService;

    @ApiOperation(value = "获取指定团契信息", notes = "根据传入标识获取详细信息")
    @ApiImplicitParam(name = "churchId", value = "团契标识", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/get/{churchId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Church getChurch(@PathVariable String churchId) {
        return churchService.get(churchId);
    }

    @ApiOperation(value = "获取团契列表", notes = "获取团契列表")
    @RequestMapping(value = "list", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public List<Church> list() {
        return churchService.list();
    }

    @ApiOperation(value = "分页获取团契列表", notes = "获取团契列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "每页取几条记录", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/list/{page}/{pageSize}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public PageInfo<Church> list(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
        return churchService.list(page, pageSize);
    }

    @ApiOperation(value = "添加团契信息", notes = "插入团契信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "团契名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "logo", value = "团契Logo", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Church add(HttpServletRequest request) {

        String churchName = request.getParameter("name");
        String logo = request.getParameter("logo");
        String churchId = CommonUtil.getUUID(16);
        Church church = new Church(churchId, churchName, logo);

        churchService.add(church);
        return church;
    }
}
