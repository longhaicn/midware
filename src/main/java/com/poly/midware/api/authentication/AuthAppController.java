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
    AuthAppService authAppService;

    @IgnoreAuth
    @ApiOperation(value = "为一个用户配置一个应用权限的开或关")
    @PostMapping(value = "/authConfigure")
    public JsonResult<String> authConfigure(String username,String appcode,int auth) {
        if(null == username || null == appcode){
            return null;
        }
        return authAppService.authConfigure(username,appcode,auth);
    }

    @IgnoreAuth
    @ApiOperation(value = "新增一个平台认证应用")
    @PostMapping(value = "/insertAuth")
    public JsonResult<String> insertAuth() {


        return authAppService.insertAuth();
    }

    @IgnoreAuth
    @ApiOperation(value = "修改一个平台认证应用信息")
    @PostMapping(value = "/updateAuth")
    public JsonResult<String> updateAuth() {
        return authAppService.updateAuth();
    }

    @IgnoreAuth
    @ApiOperation(value = "删除一个平台认证应用")
    @PostMapping(value = "/deleteAuth")
    public JsonResult<String> deleteAuth() {
        return authAppService.deleteAuth();
    }

    @IgnoreAuth
    @ApiOperation(value = "查询一个平台认证应用")
    @PostMapping(value = "/selectAuth")
    public JsonResult<String> selectAuth() {
        return authAppService.selectAuth();
    }
    @IgnoreAuth
    @ApiOperation(value = "查询所有平台认证应用")
    @PostMapping(value = "/selectAuthList")
    public JsonResult<String> selectAuthList() {
        return authAppService.selectAuthList();
    }

}
