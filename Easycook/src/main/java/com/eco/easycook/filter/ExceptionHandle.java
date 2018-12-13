package com.eco.easycook.filter;

import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
	
	private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResultBean handle(Exception e){
		if(e instanceof TGException){
			TGException tgException=(TGException) e;
			return ResultUtil.setError(tgException.getCode(),tgException.getMessage(),null);
		}else {
			logger.error("【系统异常】{}",e);
			return ResultUtil.setError(-1, "未知错误",null);
		}
	}
}
