package com.poly.midware.api.ehr;

import com.poly.midware.entity.OrganizationEntity;
import com.poly.midware.impl.OrganizationImpl;
import com.poly.midware.service.OrganizationService;
import com.poly.midware.utils.annotation.IgnoreAuth;
import com.poly.midware.utils.constant.ExceptionCode;
import com.poly.midware.utils.response.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.api.sso
 * @Author: longhai
 * @CreateDate: 2018/5/3 17:55
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */

@Api(value = "组织架构接口", description = "组织架构信息接口", basePath = "api", tags = "Organization Service APIS")
@RestController
public class OrganizationController {
    @Resource
    OrganizationService organizationService;

    @IgnoreAuth
    @ApiOperation(value = "全量同步组织架构信息")
    @PostMapping(value = "/organizationInterestSave")
    public JsonResult<String> organizationInterestSave(HttpServletRequest request, @RequestBody String data) {
        JsonResult result = new JsonResult();
        List<OrganizationEntity> list = OrganizationImpl.parseJsonAllOrganization(data);
        if(list.equals(null)||list.size()<1) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else {
            for (OrganizationEntity organizationEntity: list ) {
                System.out.println(organizationEntity);
                result = organizationService.insert(organizationEntity);
            }
        }
        return result;
    }

    @IgnoreAuth
    @ApiOperation(value = "增量同步组织架构信息")
    @PostMapping( value = "/organizationInfluencedSave")
    public JsonResult<String> organizationInfluencedSave(HttpServletRequest request, @RequestBody String data) {
        JsonResult result = new JsonResult();
        if(data.isEmpty()||data.length()<10) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else {
            result =  organizationService.organizationInfluenced(data);
        }
        return result;
    }

    @IgnoreAuth
    @ApiOperation(value = "删除一条组织架构信息")
    @PostMapping(value = "/organizationInterestDelete")
    public JsonResult<String> organizationInterestDelete(HttpServletRequest request, @RequestParam("organizationKey") String organizationKey){
        JsonResult result = new JsonResult();
        if(organizationKey.equals(null) || "".equals(organizationKey.trim())){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else{
            result = organizationService.deleteByOrganizationKey(organizationKey);
        }
        return result;
    }

    @IgnoreAuth
    @ApiOperation(value = "删除所有组织架构信息")
    @GetMapping( value = "/organizationReset")
    public JsonResult<String> deleteAllOrganization(HttpServletRequest request) {
        return organizationService.deleteAllOrganization();
    }

    @IgnoreAuth
    @ApiOperation(value = "更新一条组织架构信息")
    @PostMapping(value = "/organizationInterestUpdate")
    public JsonResult<String> organizationInterestUpdate(HttpServletRequest request, @RequestBody OrganizationEntity organizationEntity){
        JsonResult result = new JsonResult();
        if(organizationEntity.equals(null)){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else{
            result = organizationService.updateByOrganizationKey(organizationEntity);
        }
        return result;
    }

    @IgnoreAuth
    @ApiOperation(value = "查询一条组织架构信息")
    @GetMapping( value = "/organizationInterestQuery")
    public JsonResult<List<OrganizationEntity>> organizationInterestQuery(HttpServletRequest request,  String organizationKey){
        JsonResult result = new JsonResult();
        if(organizationKey.equals(null) || "".equals(organizationKey.trim())){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else{
            result = organizationService.queryByOrganizationKey(organizationKey);
        }
        return result;
    }

    @IgnoreAuth
    @ApiOperation(value = "查询组织架构信息列表")
    @GetMapping( value = "/organizationInterestList")
    public JsonResult<List<OrganizationEntity>> organizationInterestList(HttpServletRequest request){
        return  organizationService.select();
    }

    @IgnoreAuth
    @ApiOperation(value = "查询组织架构信息列表UMUN")
    @GetMapping(value = "/organizationInterestListUMUN")
    public JsonResult<List<OrganizationEntity>> organizationInterestListUMUN(HttpServletRequest request){
        return  organizationService.selectUMUN();
    }

    @IgnoreAuth
    @ApiOperation(value = "查询组织架构信息列表UMUN树TREE")
    @GetMapping( value = "/organizationInterestTreeUMUN")
    public JsonResult<List<OrganizationEntity>> organizationInterestTreeUMUN(HttpServletRequest request){
        return  organizationService.selectTreeUMUN();
    }

    @IgnoreAuth
    @ApiOperation(value = "过期组织架构信息列表")
    @GetMapping(value = "/archiveAllOrganization")
    public JsonResult<String> archiveAllOrganization(HttpServletRequest request){
        return  organizationService.archiveAllOrganization();
    }

    @IgnoreAuth
    @ApiOperation(value = "SSO全量同步组织架构信息列表")
    @RequestMapping(method = RequestMethod.POST, value = "/ssoOrganizationPushAll")
    public JsonResult<String> ssoOrganizationPushAll(HttpServletRequest request){
        System.out.println(200);
        return  organizationService.ssoOrganizationPushAll();
    }

    @IgnoreAuth
    @ApiOperation(value = "SSO清空组织架构")
    @PostMapping(value = "/ssoOrganizationReset")
    public JsonResult<String> ssoOrganizationReset(HttpServletRequest request){
        System.out.println(200);
        return  organizationService.ssoOrganizationReset();
    }

    @IgnoreAuth
    @ApiOperation(value = "SSO部分同步组织架构信息列表")
    @PostMapping( value = "/ssoOrganizationPushPartial")
    public JsonResult<String> ssoOrganizationPushPartial(HttpServletRequest request){
        return organizationService.ssoOrganizationPushPartial();
    }

}
