package com.poly.midware.api.ehr;

import com.poly.midware.entity.StuffEntity;
import com.poly.midware.impl.StuffImpl;
import com.poly.midware.service.StuffService;
import com.poly.midware.utils.constant.ExceptionCode;
import com.poly.midware.utils.annotation.IgnoreAuth;
import com.poly.midware.utils.response.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.api.sso
 * @Author: longhai
 * @CreateDate: 2018/5/3 17:55
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Api(value = "人员接口", description = "Stuff Controller", basePath = "api", tags = "Stuff APIS")
@RestController
public class StuffController {
    @Resource
    private StuffService stuffService;
    @IgnoreAuth
    @ApiOperation(value = "全量同步人员信息")
    @RequestMapping(method = RequestMethod.POST, value = "/stuffInterestSave")
    public JsonResult<String> stuffInterestSave(HttpServletRequest request, @RequestBody String data){
        JsonResult result = new JsonResult();
        List<StuffEntity> list = StuffImpl.parseJsonAllStuff(data);
        if(list.equals(null)||list.size()<1){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else{
            for (StuffEntity stuffEntity : list ){
                result = stuffService.insert(stuffEntity);
            }
        }
        return result;
    }

    @IgnoreAuth
    @ApiOperation(value = "增量同步人员信息")
    @RequestMapping(method = RequestMethod.POST, value = "/stuffInfluencedSave")
    public JsonResult<String> stuffInfluencedSave(HttpServletRequest request, @RequestBody String data){
        JsonResult result = new JsonResult();

        if(data.isEmpty()||data.length()<10){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else {
            result =  stuffService.stuffInfluenced(data);
        }
        return result;
    }
    @IgnoreAuth
    @ApiOperation(value = "删除一条人员信息")
    @RequestMapping(method = RequestMethod.POST, value = "/stuffInterestDelete")
    public JsonResult<String> stuffInterestDelete(HttpServletRequest request, @RequestParam("userName") String userName){
        JsonResult result = new JsonResult();
        if(userName.equals(null) || "".equals(userName.trim())){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else{
            result = stuffService.deleteByUserName(userName);
        }
        return result;
    }

    @IgnoreAuth
    @ApiOperation(value = "删除所有人员信息")
    @RequestMapping(method = RequestMethod.GET, value = "/stuffReset")
    public JsonResult<String> deleteAllStuff(HttpServletRequest request){
        return stuffService.deleteAllStuff();
    }

    @IgnoreAuth
    @ApiOperation(value = "过期所有人员信息")
    @RequestMapping(method = RequestMethod.GET, value = "/archiveAllStuff")
    public JsonResult<String> archiveAllStuff(HttpServletRequest request){
        return stuffService.archiveAllStuff();
    }

    @IgnoreAuth
    @ApiOperation(value = "更新一条人员信息")
    @RequestMapping(method = RequestMethod.POST, value = "/stuffInterestUpdate")
    public JsonResult<String> stuffInterestUpdate(HttpServletRequest request, @RequestBody StuffEntity stuffEntity){
        JsonResult result = new JsonResult();
        if(stuffEntity.equals(null)){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else{
            result = stuffService.updateByUserName(stuffEntity);
        }
        return result;
    }

    @IgnoreAuth
    @ApiOperation(value = "查询一条人员信息")
    @RequestMapping(method = RequestMethod.GET, value = "/stuffInterestQuery")
    public JsonResult<List<StuffEntity>> stuffInterestQuery(HttpServletRequest request, @RequestParam("userName") String userName){
        JsonResult result = new JsonResult();
        if(userName.equals(null) || "".equals(userName.trim())){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_1000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_1000);
        }else{
            result = stuffService.queryByUserName(userName);
        }
        return result;
    }

    @IgnoreAuth
    @ApiOperation(value = "查询人员信息列表")
    @RequestMapping(method = RequestMethod.GET, value = "/stuffInterestList")
    public JsonResult<List<StuffEntity>>  stuffInterestList(HttpServletRequest request){
        return stuffService.select();
    }

    @IgnoreAuth
    @ApiOperation(value = "SSO全量同步人员信息列表")
    @RequestMapping(method = RequestMethod.GET, value = "/ssoStuffPushAll")
    public JsonResult<String>  ssoStuffPushAll(HttpServletRequest request){
        return stuffService.ssoStuffPushAll();
    }
    @IgnoreAuth
    @ApiOperation(value = "SSO清空人员")
    @RequestMapping(method = RequestMethod.GET, value = "/ssoStuffReset")
    public JsonResult<String>  ssoStuffReset(HttpServletRequest request){
        return stuffService.ssoStuffReset();
    }

    @IgnoreAuth
    @ApiOperation(value = "SSO全量同步人员信息列表")
    @RequestMapping(method = RequestMethod.GET, value = "/ssoStuffPushPartial")
    public JsonResult<String>  ssoStuffPushPartial(HttpServletRequest request){
        return stuffService.ssoStuffPushPartial();
    }

}
