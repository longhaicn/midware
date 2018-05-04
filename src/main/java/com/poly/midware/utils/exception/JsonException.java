package com.poly.midware.utils.exception;

/**
 * 自定义JSON异常类
 * @ProjectName: midware
 * @Package: com.poly.midware.utils.exception
 * @Author: longhai
 * @CreateDate: 2018/5/3
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class JsonException extends Exception {

    public JsonException(String message) {
        super(message);
    }
}
