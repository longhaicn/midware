package com.poly.midware.utils.constant;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.utils.exception
 * @Author: longhai
 * @CreateDate: 2018/5/9 17:09
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ExceptionCode {

    /**没有异常*/
    public final static int EXCEPTION_CODE_0 = 0;
    public final static String EXCEPTION_MSG_0 = "正常";

    /**前端Controller层传入字符串为空或者null的情况下*/
    public final static int EXCEPTION_CODE_1000 = 1000;
    public final static String EXCEPTION_MSG_1000 = "前端Controller层传入字符串为空或者null";

    /**空字符串异常*/
    public final static int EXCEPTION_CODE_2000 = 2000;
    public final static String EXCEPTION_MSG_2000 = "空字符串异常";

    /**其他异常*/
    public final static int EXCEPTION_CODE_3000 = 3000;
    public final static String EXCEPTION_MSG_3000 = "其他异常";

    /**数据库Service层操作异常*/
    public final static int EXCEPTION_CODE_4000 = 4000;
    public final static String EXCEPTION_MSG_4000 = "数据库Service层操作异常";

    /**连接数据库测试失败*/
    public final static int EXCEPTION_CODE_5000 = 5000;
    public final static String EXCEPTION_MSG_5000 = "连接数据库测试失败异常";
}
