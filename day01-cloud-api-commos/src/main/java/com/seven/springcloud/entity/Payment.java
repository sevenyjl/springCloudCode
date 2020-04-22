package com.seven.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Payment
 * @Description 支付实体类,实现Serializable序列化接口，分布式可能会用
 * @Author seven
 * @Date 2020/4/20 13:00
 * @Version 1.0
 * id:主键
 * serial:流水号
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
