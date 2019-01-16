package com.poly.midware.api.sso;

import com.poly.midware.service.SyncService;
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

    @Scheduled(cron = "0 1 * * * ?")
    public void taskDate(){
        System.out.println("###############################每小时差异同步组织架构###############################");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        syncEvent(null);
    }

}
