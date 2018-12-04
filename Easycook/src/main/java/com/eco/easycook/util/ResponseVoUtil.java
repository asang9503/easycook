package com.eco.easycook.util;


import com.eco.easycook.ResponseVo.ResponseVo;

public class ResponseVoUtil {

    public static ResponseVo setOk(String msg) {
        return new ResponseVo(1000,msg,null);
    }

    public static ResponseVo setERROR(String msg) {
        return new ResponseVo(2000,msg,null);
    }
}
