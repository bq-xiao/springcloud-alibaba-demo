package com.spring.cloud.alibaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping
public class HomeController {
    @GetMapping(value = "/")
    public String home() {
        return "redirect:/swagger-ui/";
    }
}
