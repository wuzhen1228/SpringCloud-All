package com.wuzhen.eurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : wuzhen
 * @description :
 * @data : 2020/7/4
 * @since :
 */
@RestController
public class ConsumerController {

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @GetMapping(value = "getProviderHi")
    public String getProviderHi(){
        ServiceInstance provider = loadBalancerClient.choose("provider");
        String url = provider.getUri() + "/hello";
        System.out.println("本次调用地址：" + url);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        System.out.println("本次调用结果：" + result);
        return result;
    }
}
