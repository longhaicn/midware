package com.poly.midware.entity.unis;

import lombok.Data;

@Data
public class UnisUserEntity {

    public String comcode;	//公司代码
    public String userid;	//	用户代码
    public String username;	//	用户名
    public String pass;	//	密码
    public String deptid;	//	组织代码
    public String position;	//	职位
    public String sex;	//	性别
    public String email;	//	邮箱
    public String phone;	//	手机
}
