package org.giveu.springcloud.mjf.provider.controller;

import java.util.List;

import org.giveu.springcloud.mjf.provider.mapper.UserMapper;
import org.giveu.springcloud.mjf.provider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/hello")
	@ResponseBody
	public void hello(){
		List<User> findUsers = userMapper.findUsers();
		System.out.println("hello");
	}

}
