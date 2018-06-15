package com.poly.midware.web;

import com.google.common.base.CaseFormat;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.web
 * @Author: longhai
 * @CreateDate: 2018/5/14 14:56
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class MianTest {

    public static void main(String args[]){

        String key = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "dfsdfDDds");
        System.out.println(key);
        return;
    }
}
