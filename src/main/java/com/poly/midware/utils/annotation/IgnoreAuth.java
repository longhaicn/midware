package com.poly.midware.utils.annotation;

import java.lang.annotation.*;

/**
 * 忽略Token验证
 *
 * @ProjectName: midware
 * @Package: com.poly.midware.utils.annotation
 * @Author: longhai
 * @CreateDate: 2018/5/3
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
