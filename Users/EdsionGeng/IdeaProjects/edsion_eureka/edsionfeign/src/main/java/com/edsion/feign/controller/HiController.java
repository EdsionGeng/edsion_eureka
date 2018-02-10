package com.edsion.feign.controller;

/**
 * Created by EdsionGeng on 2018/2/10.
 */

import com.edsion.feign.service.SchedulaServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    private SchedulaServiceHi schedulaServiceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return schedulaServiceHi.sayHiFromClientOne(name);
    }
}
