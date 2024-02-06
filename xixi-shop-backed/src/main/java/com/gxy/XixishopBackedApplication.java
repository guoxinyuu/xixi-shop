package com.gxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Title: XixishopBackedApplication
 * @Author GUOXINYV
 * @Date 2024/2/6 16:40
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class XixishopBackedApplication {
    public static void main(String[] args) {
        SpringApplication.run(XixishopBackedApplication.class,args);
    }
}
