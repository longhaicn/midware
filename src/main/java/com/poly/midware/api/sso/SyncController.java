package com.poly.midware.api.sso;

import com.poly.midware.service.SyncService;
import com.poly.midware.utils.DateTimeUtils;
import com.poly.midware.utils.annotation.IgnoreAuth;
import com.poly.midware.utils.response.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.api.sso
 * @Author: longhai
 * @CreateDate: 2018/6/22 9:15
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Api(value = "组织架构接口", description = "同步信息定时任务接口", basePath = "api", tags = "Sync Service APIS")
@RestController
public class SyncController {
    @Resource
    private SyncService syncService;
    @IgnoreAuth
    @ApiOperation(value = "增量同步SSO接口（唯一）")
    @PostMapping(value = "/syncEvent")
    public JsonResult<String> syncEvent(HttpServletRequest request){

        return  syncService.syncEvent();
    }

    @IgnoreAuth
    @ApiOperation(value = "增量同步OA接口（唯一）")
    @PostMapping(value = "/syncEventOA")
    public JsonResult<String> syncEventOA(HttpServletRequest request){

        return  syncService.syncEventOA();
    }
    @Scheduled(cron = "40 * * * * ?")
    public void taskDate(){
        String datetime = DateTimeUtils.getDateStr();
        String mm[] = datetime.split(":");
        if("00".equals(mm[1])||"30".equals(mm[1])){
            System.out.println("###############################"+ datetime +" 差异同步组织架构###############################");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        syncEventOA(null);
    }

}
