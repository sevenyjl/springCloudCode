package com.seven.springcloud.controller;

import com.seven.springcloud.entity.CommonResult;
import com.seven.springcloud.entity.Payment;
import com.seven.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName PaymentController
 * @Description
 * @Author seven
 * @Date 2020/4/20 14:07
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    /**
     * 获取当前服务器端口号
     */
    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入数据成功，consul serverPort："+serverPort,result);
        }else {
            return new CommonResult(444,"插入失败",null);
        }
    }
    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查找结果："+payment);
        if (payment!=null){
            return new CommonResult(200,"查询成功，consul serverPort："+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }

}
