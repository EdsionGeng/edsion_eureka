package com.edsion.feign.service;

import org.springframework.stereotype.Component;

/**
 * Created by EdsionGeng on 2018/2/10.
 */
@Component
public class SchedualServiceHiHystric implements SchedulaServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return  "Sorry,the service stopped,we are very sorry about it and fix quickly "+name;
    }
}
