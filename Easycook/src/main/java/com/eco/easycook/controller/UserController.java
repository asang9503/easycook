package com.eco.easycook.controller;

import com.eco.easycook.pojo.EcUser;
import com.eco.easycook.service.UserService;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.token.SystemCon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@Api(value = "用户登录注册模块", tags = {"用户登录注册模块"})
public class UserController {
	
	@Autowired
	private UserService userService;
	//登录
	@ApiOperation(value = "登录",httpMethod = "GET",notes = "实现用户登录功能")
	@GetMapping("userlogin")
	public ResultBean login(String name, String password, HttpServletRequest request, HttpServletResponse response) {
		String token= "";
		if(null == token || token==""){
			ResultBean rb=userService.login(name,password,request.getRemoteAddr());
			if(rb.getCode()==SystemCon.ROK){
				//存储令牌到Cookie
				//CookieUtil.setCK(response,SystemCon.TOKECOOKIE,rb.getMsg());
				rb.setCode(SystemCon.ROK);
				rb.setMsg("登录成功");
				return rb;
			}else {
				rb.setCode(SystemCon.RERROR1);
				rb.setMsg("用户名或密码错误");
				return rb;
			}
		}else{
			//存在Token
			//校验Token
			return userService.checkLogin(token);
		}
	}
	@ApiOperation(value = "用户注册",httpMethod = "GET",notes = "实现用户注册功能" )
	@GetMapping("userregist")
	public ResultBean regist(EcUser user) throws Exception {
		
		return userService.addUser(user);
	}
	//检查是否登录
	@GetMapping("userlogincheck")
	public ResultBean check(String token) {
		return userService.checkLogin(token);
	}
	
	//注销
	@ApiOperation(value = "注销，退出登录",httpMethod = "GET",notes = "实现用户退出登录功能" )
	@GetMapping("userloginout")
	public ResultBean loginOut(String token) {
		ResultBean resultBean = userService.loginOut(token);
		return resultBean;
	}
}
