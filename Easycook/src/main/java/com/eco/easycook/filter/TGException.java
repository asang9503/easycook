package com.eco.easycook.filter;

public class TGException extends RuntimeException {
	private  Integer code;
	
	
	public TGException(ResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code=resultEnum.getCode();
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
}
