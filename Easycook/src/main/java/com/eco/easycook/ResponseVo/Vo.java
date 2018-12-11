package com.eco.easycook.ResponseVo;

public class Vo<T> {

    private int code;

    private String msg;

    private Object data;

    public Vo() {
    }

    public Vo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Vo OK(){
        Vo vo	=new Vo();
        vo.setCode(1000);
        vo.setMsg("success");

        return  vo;
    }

    public static Vo ERROR(){
        Vo vo	=new Vo();
        vo.setCode(2000);
        vo.setMsg("error");

        return  vo;
    }


}
