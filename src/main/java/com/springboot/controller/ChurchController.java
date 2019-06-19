package com.springboot.controller;

import com.springboot.entity.Church;
import com.springboot.service.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/church")
public class ChurchController {
    @Autowired
    private ChurchService churchService;

    // 获取指定教会团契信息
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getChurch(@RequestParam("id") String churchId) {
        Church church = churchService.get(churchId);
        return church.toString();
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String hello() {
        return "show";
    }
}
