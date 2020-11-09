package com.spring.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/config/index")
@RefreshScope
public class IndexController {
    @Value("${common.message}")
    private String message;
    @Autowired
    private Environment environment;

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    @ResponseBody
    public String echo() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        return "[" + address.getHostAddress() + "]this is nacos-discovery-config";
    }

    @RequestMapping(value = "/value", method = RequestMethod.GET)
    @ResponseBody
    public String value() {
        return message;
    }

    @RequestMapping(value = "/value/{key}", method = RequestMethod.GET)
    @ResponseBody
    public String value(@PathVariable String key) {
        return environment.getProperty(key, "this is default!");
    }
}
