package com.poly.midware.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: longhai
 * @CreateDate: 2018/11/15 10:16
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableSwagger2Doc {
}
