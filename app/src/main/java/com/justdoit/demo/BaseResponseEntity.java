package com.justdoit.demo;

import com.google.gson.annotations.SerializedName;

/**
 * @author : chengzhijun
 * @date : 2018/6/25
 * @email : 1031612246@QQ.COM
 * @description : 用于存放所有接口统一的返回的字段,T标示每个接口不同的部分
 */
public class BaseResponseEntity<T> {

    private int code;
    /**
     * 此处只是因为该API的根节点名字为这个,一般应用不需要这样
     */
    @SerializedName("HeWeather6")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
