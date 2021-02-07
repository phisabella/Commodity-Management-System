package com.project1.utils;

public class Respone {

    private int code;

    private String msg;

    private Object data;


    public Respone() {
    }

    public Respone(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Respone(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Respone(int code, Object data) {
        this.code = code;
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
}