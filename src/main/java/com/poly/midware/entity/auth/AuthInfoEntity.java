package com.poly.midware.entity.auth;

import lombok.Data;

import java.util.Date;

@Data
public class AuthInfoEntity {
    private int id;
    private String username;
    private String appcode;
    private int auth;
    private int syncflag;
    private Date date;

}
