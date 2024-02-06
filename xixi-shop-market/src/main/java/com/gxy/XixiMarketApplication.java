package com.gxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Title: XixiMarketApplication
 * @Author GUOXINYV
 * @Date 2024/2/6 18:56
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class XixiMarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(XixiMarketApplication.class,args);
    }
}
