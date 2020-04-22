package com.seven.springcloud.dao;

import com.seven.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Interface PaymentDao
 * @Description 支付dao接口
 * @Author seven
 * @Date 2020/4/20 13:43
 * @Version 1.0
 **/
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
