package com.seven.springcloud.controller;

import com.seven.springcloud.entity.CommonResult;
import com.seven.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description 订单controller
 * @Author seven
 * @Date 2020/4/20 14:56
 * @Version 1.0
 **/

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
}
