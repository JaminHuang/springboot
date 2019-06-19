package com.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Church;
import com.springboot.service.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/church")
public class ChurchController {
    @Autowired
    private ChurchService churchService;

    // 获取指定教会/团契信息
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getChurch(@RequestParam("id") String churchId) {
        Church church = churchService.get(churchId);
        return church.toString();
    }

    // 获取教会/团契列表
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Church> list() {
        return churchService.list();
    }

    // 分页获取教会/团契列表
    @RequestMapping(value = "page_list", method = RequestMethod.GET)
    public PageInfo<Church> list(int page, int pageSize) {
        return churchService.list(page, pageSize);
    }
}
