package org.giveu.springcloud.mjf.provider.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class User extends Model<User> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@TableId("id")
	private Integer id;
	@TableField("username")
	private String userName;
	@TableField("name")
	private String name;
	@TableField("age")
	private Integer age;
	
	//余额
	@TableField("balance")
	private Double balance;
	
	public User(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
}
