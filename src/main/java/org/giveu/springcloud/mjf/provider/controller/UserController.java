package org.giveu.springcloud.mjf.provider.controller;

import java.util.List;

import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.giveu.springcloud.mjf.provider.mapper.UserMapper;
import org.giveu.springcloud.mjf.provider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Value("${spring.mvc.view.prefix}")
	private String prefix;
	@RequestMapping("/hello")
	@ResponseBody
	public List<User> hello(){
		List<User> findUsers = userMapper.findUsers();
		return findUsers;
	}
	
	@RequestMapping("/index")
	public String index(){
		return "/index.html";
	}
}
