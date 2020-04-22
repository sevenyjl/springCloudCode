package com.seven.springcloud.service.impl;

import com.seven.springcloud.dao.PaymentDao;
import com.seven.springcloud.entity.Payment;
import com.seven.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Description paymentService 实现类
 * @Author seven
 * @Date 2020/4/20 14:04
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
