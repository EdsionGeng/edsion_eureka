package com.edsion.ribbon.service.serviceimpl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by EdsionGeng on 2018/2/7.
 */
@Service
public class HelloServiceImpl {
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hiError")
    public String helloService(String name) {
        // System.out.println(restTemplate.getErrorHandler());
        return restTemplate.getForObject("http://HELLO-SERVICE/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",我这里挂了，请求支援!";
    }
}
