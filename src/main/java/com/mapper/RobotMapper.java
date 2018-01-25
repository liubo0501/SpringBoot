package com.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Robot;

/**
 * @ClassName cn.saytime.mapper.UesrMapper
 * @Description
 */
@Repository
public interface RobotMapper {

	public List<Robot> getRobotList();
	
	
	public Robot getRobotById(String robotId);
}
