package com.spring.cloud.alibaba;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryConfigApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosDiscoveryConfigApplication.class, args);
        while(true) {
            //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
            String config = applicationContext.getEnvironment().getProperty("common.message");
            System.err.println("Get config from Nacos Server: " + config);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
