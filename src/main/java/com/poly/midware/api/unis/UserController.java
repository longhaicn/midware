package com.poly.midware.api.unis;//package com.poly.midware.api.unis;
//
//import com.poly.midware.entity.unis.UnisUserEntity;
//import com.poly.midware.utils.annotation.IgnoreAuth;
//import com.poly.midware.utils.response.JsonResult;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Api(value = "紫光档案系统数据接口", description = "工具性接口", basePath = "api", tags = "Connection Test APIS")
//@RestController
//public class UserController {
//
//    @IgnoreAuth
//    @ApiOperation(value = "测试连接数据")
//    @GetMapping(value = "/syncUnisUser")
//    public JsonResult<String> testConn(HttpServletRequest request) {
//        JsonResult<String> result = new JsonResult<>();
//        WebServiceUser webServiceUser =new WebServiceUser();
//        UnisUserEntity userEntity = new UnisUserEntity();
//        userEntity.setComcode("保臻科技");
//        userEntity.setDeptid("董事会");
//        userEntity.setEmail("lijuan@shenzhenpoly.com");
//        userEntity.setPass("123456");
//        userEntity.setPhone("13066668888");
//        userEntity.setSex("女");
//        userEntity.setUsername("李娟");
//        userEntity.setPosition("CEO");
//        userEntity.setUserid("06101088");
//
//
//
//        return  result;
//    }
//}
