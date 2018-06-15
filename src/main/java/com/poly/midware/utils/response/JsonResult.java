package com.poly.midware.utils.response;

import com.poly.midware.utils.constant.ExceptionCode;

import java.io.Serializable;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.utils.response
 * @Author: longhai
 * @CreateDate: 2018/5/7 17:40
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**编码 1成功 0失败*/
    private int code = 1;
    /**异常码*/
    private int expCode = ExceptionCode.EXCEPTION_CODE_0;
    /**异常码描述*/
    private String expMsg = ExceptionCode.EXCEPTION_MSG_0;
    /**返回数据体*/
    private T data;
    /**返回数据条数*/
    private int row = 0;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getExpCode() {
        return expCode;
    }

    public void setExpCode(int expCode) {
        this.expCode = expCode;
    }

    public String getExpMsg() {
        return expMsg;
    }

    public void setExpMsg(String expMsg) {
        this.expMsg = expMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
