package com.poly.midware.entity;

import java.util.Date;

/**
 * 用户实体类
 * @ProjectName: midware
 * @Package: com.poly.midware.entity
 * @Author: longhai
 * @CreateDate: 2018/5/3
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class User {
    private long id;
    private String account;
    private String name;
    private Date createAt;
    private Date loginAt;

    public void setId(long id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
    }

    public long getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getLoginAt() {
        return loginAt;
    }
}
