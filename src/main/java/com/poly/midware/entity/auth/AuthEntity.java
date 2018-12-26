package com.poly.midware.entity.auth;

import lombok.Data;

import java.util.List;

@Data
public class AuthEntity {

    private List<String> usernames;

    private String appcode;
}
