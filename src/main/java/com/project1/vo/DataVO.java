package com.project1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DataVO<T> {
    private Integer code;
    private String message;
    private Integer count;
    private List<T> data;

    public DataVO(Integer code, String message, Integer count, List<T> data) {
        this.code = code;
        this.message = message;
        this.count = count;
        this.data = data;
    }

    public DataVO() {
    }

    @Override
    public String toString() {
        return "DataVO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
