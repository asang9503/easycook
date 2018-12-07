package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcUser;
import com.eco.easycook.util.ResultBean;

public interface UserService {
	
	//登录
	ResultBean login(String name,String password,String ip);
	//检验是否登录
	ResultBean checkLogin(String token);
	//注销
	ResultBean loginOut(String token);
	//注册
	int addUser(EcUser user);
}
