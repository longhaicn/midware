package com.poly.midware.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录用户信息
 *
 * @ProjectName: midware
 * @Package: com.poly.midware.utils.annotation
 * @Author: longhai
 * @CreateDate: 2018/5/3
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {

}
