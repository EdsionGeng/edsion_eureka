package com.edsion.ribbon.controller;

import com.edsion.ribbon.service.serviceimpl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by EdsionGeng on 2018/2/7.
 */
@RestController
public class HelloController {
    @Autowired
    private HelloServiceImpl helloService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.helloService(name);
    }
}
