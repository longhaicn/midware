package com.poly.midware.utils;

/**
 * 统一的JSON异常返回对象
 *
 * @ProjectName: midware
 * @Package: com.poly.midware.exception
 * @Author: longhai
 * @CreateDate: 2018/5/3
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
