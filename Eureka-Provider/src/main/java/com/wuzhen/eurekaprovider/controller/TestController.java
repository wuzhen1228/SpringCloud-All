package com.wuzhen.eurekaprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wuzhen
 * @description :
 * @data : 2020/7/4
 * @since :
 */
@RestController
public class TestController {

    @GetMapping(value = "hello")
    public String hello(){
        return "provider-1";
    }
}
