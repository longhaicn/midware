package com.poly.midware.service;

import com.poly.midware.mapper.AuthAppMapper;
import com.poly.midware.utils.response.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("authenticateService")
public class AuthAppService {

    @Resource
    AuthAppMapper authAppMapper;

    public JsonResult<String> selectAuth() {
        JsonResult<String> result = new JsonResult<>();

        authAppMapper.selectAuth();
        return result;
    }

    public JsonResult<String> deleteAuth() {
        JsonResult<String> result = new JsonResult<>();


        return result;
    }

    public JsonResult<String> updateAuth() {
        JsonResult<String> result = new JsonResult<>();


        return result;
    }

    public JsonResult<String> insertAuth() {
        JsonResult<String> result = new JsonResult<>();


        return result;
    }

    public JsonResult<String> selectAuthList() {
        JsonResult<String> result = new JsonResult<>();
        authAppMapper.selectAuthList();

        return result;
    }
}
