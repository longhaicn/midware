package com.poly.midware.service;

import com.poly.midware.mapper.AuthInfoMapper;
import com.poly.midware.utils.response.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("authInfoService")
public class AuthInfoService {

    @Resource
    private AuthInfoMapper authInfoMapper;
    public JsonResult<String> addauth(String username, String appcode, String auth) {


        return null;
    }
}
