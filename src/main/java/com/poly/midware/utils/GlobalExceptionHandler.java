package com.poly.midware.utils;

import com.poly.midware.utils.exception.JsonException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统统一异常处理控制类
 * @ProjectName: midware
 * @Package: com.poly.midware.exception
 * @Author: longhai
 * @CreateDate: 2018/5/3
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ErrorInfo<String> info = new ErrorInfo<>();
        info.setCode(ErrorInfo.ERROR);
        info.setMessage(e.getMessage());
        info.setUrl(request.getRequestURL().toString());
        info.setData(e.getMessage());
        return info;
    }

    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, JsonException e) throws Exception {
        ErrorInfo<String> info = new ErrorInfo<>();
        info.setCode(ErrorInfo.ERROR);
        info.setMessage(e.getMessage());
        info.setUrl(request.getRequestURL().toString());
        info.setData("error data");
        return info;
    }
}
