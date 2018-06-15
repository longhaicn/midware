package com.poly.midware.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制类
 *
 * @ProjectName: midware
 * @Package: com.poly.midware.web
 * @Author: longhai
 * @CreateDate: 2018/5/3
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!!";
    }
}
