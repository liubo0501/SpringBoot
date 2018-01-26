package com.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.entity.Robot;
import com.entity.User;
import com.mapper.RobotMapper;
import com.mapper.UserMapper;
import com.redis.RedisClient;
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
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired  
	private RedisClient redisClient;  
	
    @RequestMapping("/hello1")
    public String Hello(){
    	
    	 logger.debug("This is a debug message");  
         logger.info("This is an info message");  
         logger.warn("This is a warn message");  
         logger.error("This is an error message");
         
    	User user = userMapper.getUserById(1);
    	user.setName("管理员123");
    	userMapper.update(1, user);
    	logger.error(user.getUsername());
    	
    	stringRedisTemplate.opsForValue().set("username", user.getUsername());
    	
    	logger.error("aaaaa   " + stringRedisTemplate.opsForValue().get("username"));
    	
    	service.hello();
//       List<Robot> map = robotMapper.getRobotList();
       Robot map = robotMapper.getRobotById("17WR201801");
       try {
		redisClient.set("map",JSON.toJSONString(map) );
	} catch (Exception e) {
		e.printStackTrace();
	}  
      
       logger.error(redisClient.get("map"));
       return "Hello World";
    }
    
    @Autowired
    private  Environment env;
    
    @RequestMapping("/sample")
    public String sample(){
        return "spring boot success ! and profile is ==>"+
        env.getProperty("server.port")+"=====>";
    }
    
    
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
    
    @GetMapping("/index")
    public ResponseEntity index(HttpSession httpSession) {
        httpSession.setAttribute("user", "helloword123");
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/helloword")
    public ResponseEntity hello(HttpSession httpSession) {
        return ResponseEntity.ok(httpSession.getAttribute("user"));
    }
}