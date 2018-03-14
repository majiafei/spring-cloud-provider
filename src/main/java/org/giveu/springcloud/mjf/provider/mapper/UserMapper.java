package org.giveu.springcloud.mjf.provider.mapper;

import java.io.Serializable;
import java.util.List;

import org.giveu.springcloud.mjf.provider.model.User;

import com.baomidou.mybatisplus.mapper.BaseMapper;


public interface UserMapper extends BaseMapper<User, Serializable> {
	
	public List<User> findUsers();

}
