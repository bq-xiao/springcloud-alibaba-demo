package com.spring.cloud.alibaba;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryConfigApplication.class, args);
    }
}
