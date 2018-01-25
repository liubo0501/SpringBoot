package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	public void hello(){
   	    logger.debug("MyService This is a debug message");  
        logger.info("MyService This is an info message");  
        logger.warn("MyService This is a warn message");  
        logger.error("MyService This is an error message");
	}
}
