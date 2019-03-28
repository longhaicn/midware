package com.poly.midware.api;

import com.poly.midware.service.ConnectionTestService;
import com.poly.midware.utils.annotation.IgnoreAuth;
import com.poly.midware.utils.response.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.api
 * @Author: longhai
 * @CreateDate: 2018/5/28 17:02
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Api(value = "连接测试接口", description = "工具性接口", basePath = "api", tags = "Connection Test APIS")
@RestController
public class ConnectionTestController {
    @Resource
    private ConnectionTestService connectionTestService;


    @IgnoreAuth
    @ApiOperation(value = "获取人员上次同步时间戳")
    @GetMapping(value = "/influnencedStfDate")
    public JsonResult<String> influnencedStfDate(HttpServletRequest request) {

        return  connectionTestService.influnencedStfDate();
    }

    @IgnoreAuth
    @ApiOperation(value = "获取组织结构上次同步时间戳")
    @GetMapping(value = "/influnencedOrgDate")
    public JsonResult<String> influnencedOrgDate(HttpServletRequest request) {
        return  connectionTestService.influnencedOrgDate();
    }


}
