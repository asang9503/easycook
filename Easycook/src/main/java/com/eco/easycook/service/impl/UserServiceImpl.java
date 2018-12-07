package com.eco.easycook.service.impl;

import com.alibaba.fastjson.JSON;
import com.eco.easycook.mapper.EcUserMapper;
import com.eco.easycook.pojo.EcUser;
import com.eco.easycook.mapper.JedisUtil;
import com.eco.easycook.service.UserService;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.ResultUtil;
import com.eco.easycook.util.token.StringUtil;
import com.eco.easycook.util.token.SystemCon;
import com.eco.easycook.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private  EcUserMapper userMapper;
	
	JedisUtil jedisUtil = new JedisUtil("120.79.198.64",6379,"root");
	
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
				//采用Hash类型 存储的键为固定字符串+Token 存储的值是对应用户信息的json字符串
			
				//Jedis jedis = new Jedis("120.79.198.64",6379);
				//jedis.auth("root");
				//jedis.connect();
				//jedis.hset(SystemCon.TOKENHASH,"token:"+""+token,JSON.toJSONString(user));
				jedisUtil.addHash(""+SystemCon.TOKENHASH,"token:"+""+token,JSON.toJSONString(user));
				//jedis.close();
				
				return ResultUtil.setOK("登录成功",token);
			}
		}
		return ResultUtil.setError(100001,"登录失败",null);
	}
	
	@Override
	public ResultBean checkLogin(String token) {
		System.out.println(token);
		String value = jedisUtil.getHash(SystemCon.TOKENHASH, "token:" + token);
		System.out.println(value);
		if (StringUtil.checkNoEmpty(value)) {
			EcUser user = JSON.parseObject(value, EcUser.class);
			return ResultUtil.setOK("登录有效", user);
		} else {
			return ResultUtil.setError(SystemCon.RERROR1, "登录失效，请重新登录", null);
		}
	}
	
	@Override
	public ResultBean loginOut(String token) {
		jedisUtil.delHash(SystemCon.TOKENHASH,"token:"+token);
		return ResultUtil.setOK("注销成功",null);
	}
	
	@Override
	public int addUser(EcUser user) {
		return userMapper.insert(user);
	}
}
