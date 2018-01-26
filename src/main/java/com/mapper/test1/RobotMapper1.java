package com.mapper.test1;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Robot;

/**
 * @ClassName cn.saytime.mapper.UesrMapper
 * @Description
 */
@Repository
public interface RobotMapper1 {

	public List<Robot> getRobotList();
	
	
	public Robot getRobotById(String robotId);
}
