package com.eco.easycook.controller;

import com.eco.easycook.pojo.EcUser;
import com.eco.easycook.service.UserService;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.token.CookieUtil;
import com.eco.easycook.util.token.SystemCon;
import com.eco.easycook.util.token.TokenUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	//登录
	//@ApiOperation(value = "登录",httpMethod = "GET",notes = "实现用户登录功能")
	@PostMapping("userlogin")
	public ResultBean login(String name, String password, HttpServletRequest request, HttpServletResponse response) {
		String token= "";
		if(null == token || token==""){
			ResultBean rb=userService.login(name,password,request.getRemoteAddr());
			if(rb.getCode()==SystemCon.ROK){
				//存储令牌到Cookie
				//CookieUtil.setCK(response,SystemCon.TOKECOOKIE,rb.getMsg());
				rb.setMsg("登录成功");
				return rb;
			}else {
				return rb;
			}
		}else{
			//存在Token
			//校验Token
			return userService.checkLogin(token);
		}
	}
	@PostMapping("userregist")
	public int regist(EcUser user) {
		return userService.addUser(user);
	}
	//检查是否登录
	@PostMapping("userlogincheck")
	public ResultBean check(String token) {
		System.out.println(token);
		//tring tk = CookieUtil.getCk(request, SystemCon.TOKECOOKIE);
		//ResultBean resultBean = userService.checkLogin(tk);
		//if (resultBean.getCode() == SystemCon.ROK) {
			//存在就刷新时间
		//	CookieUtil.setCK(response, SystemCon.TOKECOOKIE, TokenUtil.updateToken(TokenUtil.parseToken(tk)));
			
		//} else {
			//Token无效 Cookie就需要删除
			///Cookie cookie = new Cookie(SystemCon.TOKECOOKIE, "");
			//cookie.setMaxAge(0);
			//response.addCookie(cookie);
		
		//}
		return userService.checkLogin(token);
	}
	
	//注销
	@GetMapping("userloginout")
	public ResultBean loginOut(String token) {
		ResultBean resultBean = userService.loginOut(token);
		//Token无效 Cookie就需要删除
		//Cookie cookie = new Cookie(SystemCon.TOKECOOKIE, "");
		//cookie.setMaxAge(0);
		//response.addCookie(cookie);
		return resultBean;
	}
}
