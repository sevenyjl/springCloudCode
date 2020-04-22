package com.seven.springcloud.service;

import com.seven.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @Interface PaymentService
 * @Description paymentService层
 * @Author seven
 * @Date 2020/4/20 13:48
 * @Version 1.0
 **/
@Service
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
