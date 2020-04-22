package com.seven.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName OrderMain80
 * @Description order主程序
 * @Author seven
 * @Date 2020/4/20 14:50
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain80.class);
    }
}
