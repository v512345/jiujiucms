package com.xuliangjun.jiujiucms.modules.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xuliangjun.jiujiucms.common.dao.DaoSupport;
import com.xuliangjun.jiujiucms.modules.system.entry.User;


@Service("userService")
public class UserService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/*
	* 登录判断
	*/
	public List<User> getUserByNameAndPwd(User user)throws Exception{
		return (List<User>)dao.findForObject("UserXMapper.getUserInfo", user);
	}
	
	
	
}
