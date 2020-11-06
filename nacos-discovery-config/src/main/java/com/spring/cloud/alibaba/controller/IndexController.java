package com.spring.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/config/index")
@RefreshScope
public class IndexController {
    @Value("${common.message}")
    private String message;

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
}
