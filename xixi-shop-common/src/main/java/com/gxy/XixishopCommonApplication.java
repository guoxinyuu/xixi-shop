package com.gxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: XixishopCommonApplication
 * @Author GUOXINYV
 * @Date 2024/2/6 18:53
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class XixishopCommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(XixishopCommonApplication.class,args);
    }
}
