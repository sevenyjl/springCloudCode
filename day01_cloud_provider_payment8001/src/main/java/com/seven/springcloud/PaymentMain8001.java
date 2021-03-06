package com.seven.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PaymentMain8001
 * @Description spring 主函数入口，启动入口
 * @Author seven
 * @Date 2020/4/20 12:02
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.seven.springcloud.dao")
@EnableEurekaClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
