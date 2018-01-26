package com.mapper.test2;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.entity.User;

/**
 * @ClassName cn.saytime.mapper.UesrMapper
 * @Description
 */
@Repository
public interface UserMapper2 {

	User getUserById(Integer id);

	public List<User> getUserList();

	public int add(User user);

	public int update(@Param("id") Integer id, @Param("user") User user);

	public int delete(Integer id);
}
