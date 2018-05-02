package com.netposa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zookeeper")
@RefreshScope // 必须添加，否则不会自动刷新name的值
public class ZookeeperController {

    @Autowired
    private Environment environment;

    @Value("${redis.host}")
    private String name;

    @GetMapping
    public String hello() {
        return "Hello, " + name;
    }

    @GetMapping("/env")
    public String test() {
        String name = environment.getProperty("name");
        System.out.println(name);
        return "Hello," + name;
    }

}