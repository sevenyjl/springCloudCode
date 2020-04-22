package com.seven.springcloud.controller;

import com.seven.springcloud.entity.CommonResult;
import com.seven.springcloud.entity.Payment;
import com.seven.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    /**
     * 服务发现配置
     * */
    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入数据成功，serverPort："+serverPort,result);
        }else {
            return new CommonResult(444,"插入失败",null);
        }
    }
    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查找结果："+payment);
        if (payment!=null){
            return new CommonResult(200,"查询成功，serverPort："+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("============service"+service);
        }
        return services;
    }
    @GetMapping("/discovery2")
    public Object discovery2(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+
                    instance.getPort()+"\t"+instance.getUri());
        }
        return instances;
    }

}
