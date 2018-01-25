package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.entity.Robot;
import com.entity.User;
import com.mapper.RobotMapper;
import com.mapper.UserMapper;
import com.service.MyService;

@RestController
public class MyController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RobotMapper robotMapper;
	@Autowired
	private MyService service;
	
    @RequestMapping("/hello1")
    public String Hello(){
    	
    	 logger.debug("This is a debug message");  
         logger.info("This is an info message");  
         logger.warn("This is a warn message");  
         logger.error("This is an error message");
         
    	User user = userMapper.getUserById(1);
    	user.setName("管理员123");
    	userMapper.update(1, user);
    	System.out.println(user.getUsername());
    	
    	service.hello();
//       List<Robot> map = robotMapper.getRobotList();
       Robot map = robotMapper.getRobotById("17WR201801");
       System.out.println(JSON.toJSONString(map));
        return "Hello World";
    }
    
    @Autowired
    private  Environment env;
    
    @RequestMapping("/sample")
    public String sample(){
        return "spring boot success ! and profile is ==>"+
        env.getProperty("server.port")+"=====>";
    }
}