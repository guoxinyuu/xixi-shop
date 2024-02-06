package com.gxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: XixishopGatewayApplication
 * @Author GUOXINYV
 * @Date 2024/2/6 18:55
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class XixishopGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(XixishopGatewayApplication.class,args);
    }
}
