package com.poly.midware.api.authentication;

import com.poly.midware.service.AuthAppService;
import com.poly.midware.utils.annotation.IgnoreAuth;
import com.poly.midware.utils.response.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "应用列表信息接口", description = "应用列表信息接口", basePath = "api", tags = "AuthApp Test APIS")
@RestController
public class AuthAppController {

    @Resource
    private AuthAppService authAppService;

    @IgnoreAuth
    @ApiOperation(value = "测试连接数据")
    @PostMapping(value = "/insertAuth")
    public JsonResult<String> insertAuth() {


        return authAppService.insertAuth();
    }

    @IgnoreAuth
    @ApiOperation(value = "测试连接数据")
    @PostMapping(value = "/updateAuth")
    public JsonResult<String> updateAuth() {


        return authAppService.updateAuth();
    }

    @IgnoreAuth
    @ApiOperation(value = "测试连接数据")
    @PostMapping(value = "/deleteAuth")
    public JsonResult<String> deleteAuth() {


        return authAppService.deleteAuth();
    }

    @IgnoreAuth
    @ApiOperation(value = "测试连接数据")
    @PostMapping(value = "/selectAuth")
    public JsonResult<String> selectAuth() {


        return authAppService.selectAuth();
    }
    @IgnoreAuth
    @ApiOperation(value = "测试连接数据")
    @PostMapping(value = "/selectAuth")
    public JsonResult<String> selectAuthList() {


        return authAppService.selectAuthList();
    }

}
