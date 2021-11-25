package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private T data;

    private JsonResult(int code) {
        this.code = code;
    }

    private JsonResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private JsonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 使之不在json序列化结果当中
    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResultCode.SUCCESS.getCode();
    }

    public int getcode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static <T> JsonResult<T> createBySuccess() {
        return new JsonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc());
    }

    public static <T> JsonResult<T> createBySuccessMessage(String msg) {
        return new JsonResult<T>(ResultCode.SUCCESS.getCode(), msg);
    }

    public static <T> JsonResult<T> createBySuccess(T data) {
        return new JsonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), data);
    }

    public static <T> JsonResult<T> createBySuccess(String msg, T data) {
        return new JsonResult<T>(ResultCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> JsonResult<T> createByError() {
        return new JsonResult<T>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getDesc());
    }

    public static <T> JsonResult<T> createByErrorMessage(String errorMessage) {
        return new JsonResult<T>(ResultCode.ERROR.getCode(), errorMessage);
    }

    public static <T> JsonResult<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new JsonResult<T>(errorCode, errorMessage);

    }
}

