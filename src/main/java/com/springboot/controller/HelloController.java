package com.springboot.controller;

import com.springboot.config.WebSiteConfig;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class HelloController {

    @Autowired
    private WebSiteConfig webSiteConfig;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello spring boot";
    }

    @GetMapping("/config")
    public String getConfig() {
        return webSiteConfig.toString();
    }
}
