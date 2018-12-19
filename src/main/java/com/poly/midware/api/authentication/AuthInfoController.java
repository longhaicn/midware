package com.poly.midware.api.authentication;

import com.poly.midware.service.AuthInfoService;
import com.poly.midware.utils.annotation.IgnoreAuth;
import com.poly.midware.utils.response.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AuthInfoController {

    @Resource
    private AuthInfoService authInfoService;
    @IgnoreAuth
    @ApiOperation(value = "测试连接数据")
    @PostMapping(value = "/addauth")
    public JsonResult<String> addauth(String username,String appcode,String auth) {


        return authInfoService.addauth(username,appcode,auth);
    }
}
