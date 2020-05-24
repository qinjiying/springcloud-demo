package com.demo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //本服务启动后会自动注册进Eureka中心
@MapperScan(value = "com.demo.springcloud.mapper")
//扫描所有Mapper接口
@SpringBootApplication
public class ProductProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_8002.class, args);
    }
}
