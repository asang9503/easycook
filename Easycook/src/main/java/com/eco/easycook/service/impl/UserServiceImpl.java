package com.eco.easycook.service.impl;

import com.alibaba.fastjson.JSON;
import com.eco.easycook.mapper.EcUserMapper;
import com.eco.easycook.pojo.EcUser;
import com.eco.easycook.mapper.JedisUtil;
import com.eco.easycook.service.UserService;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.ResultUtil;
import com.eco.easycook.util.token.SystemCon;
import com.eco.easycook.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private  EcUserMapper userMapper;
	
	 JedisPool jedisPool = new JedisPool("120.79.198.64",6379);
	 JedisUtil jedisUtil = new JedisUtil(jedisPool,"root");
	
	@Override
	public ResultBean login(String name, String password, String ip) {
		//根据名字查询对象
		EcUser user = userMapper.selectByName(name);
		if(null != user){
			if(user.getEcPassword().equals(password)){
				//登录成功
				//生成令牌
				String token=TokenUtil.createToken(JSON.toJSONString(user),user.getEcUid());
				//存储令牌到Redis
				jedisUtil.addHash(SystemCon.TOKENHASH,"token:"+token,JSON.toJSONString(user));
				return ResultUtil.setOK("登录成功",token);
			}
		}
		return ResultUtil.setError(100001,"登录失败",null);
	}
	
	@Override
	public ResultBean checkLogin(String token) {
		String value = jedisUtil.getHash(SystemCon.TOKENHASH,"token:"+token);
		
		System.out.println("value:"+value);
		if (null != value) {
			EcUser user = JSON.parseObject(value, EcUser.class);
			return ResultUtil.setOK("登录有效", user);
		} else {
			return ResultUtil.setError(SystemCon.RERROR1, "登录失效，请重新登录", null);
		}
	}
	
	@Override
	public ResultBean loginOut(String token) {
		String value1 = jedisUtil.getHash(SystemCon.TOKENHASH,"token:"+token);
		System.out.println("注销前"+value1);
		jedisUtil.delHash(SystemCon.TOKENHASH,"token:"+token);
		String value2 = jedisUtil.getHash(SystemCon.TOKENHASH, "token:" + token);
		System.out.println("注销后"+value2);
		if (null != value2 ){
			return ResultUtil.setOK("注销成功",null);
			
		}else {
			return ResultUtil.setError(SystemCon.RERROR1,"注销失败",null);
			
		}
	}
	
	@Override
	public ResultBean addUser(EcUser user)  {
		ResultBean rb = new ResultBean();
		if( null != user.getEcPassword() &&null != user.getEcUsername()){
			try {
				if(true == userMapper.insert(user))
				rb.setCode(SystemCon.ROK);
				rb.setMsg("注册成功");
				return  rb;
			} catch (Exception e) {
				e.printStackTrace();
				rb.setCode(SystemCon.RERROR1);
				rb.setMsg("注册失败");
				return  rb;
			}
		}
		return rb;
	}
}
