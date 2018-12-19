package com.poly.midware.service;

import com.alibaba.fastjson.JSONObject;
import com.poly.midware.entity.AppInfoEntity;
import com.poly.midware.impl.SyncImpl;
import com.poly.midware.mapper.AuthAppMapper;
import com.poly.midware.utils.HttpUtils;
import com.poly.midware.utils.TokenUtils;
import com.poly.midware.utils.constant.ExceptionCode;
import com.poly.midware.utils.constant.SsoApi;
import com.poly.midware.utils.response.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("authAppService")
public class AuthAppService {

    @Resource
    AuthAppMapper authAppMapper;

    public JsonResult<String> selectAuth() {
        JsonResult<String> result = new JsonResult<>();
        String appcode="NC";
        authAppMapper.selectAuth(appcode);
        return result;
    }

    public JsonResult<String> deleteAuth() {
        JsonResult<String> result = new JsonResult<>();
        String appcode="NC";
        authAppMapper.deleteAuth(appcode);
        return result;
    }

    public JsonResult<String> updateAuth() {
        JsonResult<String> result = new JsonResult<>();
        AppInfoEntity appEntity= new AppInfoEntity();
        authAppMapper.updateAuth(appEntity.getId(),appEntity.getAppname(),appEntity.getAppname(),appEntity.getAppuuid());
        return result;
    }

    public JsonResult<String> insertAuth() {
        JsonResult<String> result = new JsonResult<>();
        AppInfoEntity appEntity= new AppInfoEntity();
        authAppMapper.insertAuth(appEntity);
        return result;
    }

    public JsonResult<String> selectAuthList() {
        JsonResult<String> result = new JsonResult<>();
        authAppMapper.selectAuthList();
        return result;
    }

    public JsonResult<String> authConfigure(String username,String appcode,int auth) {
        String token = TokenUtils.getToken();
        JsonResult result = new JsonResult();

        try {
            JSONObject object = new JSONObject();
            AppInfoEntity app = authAppMapper.selectAuth(appcode);
            if (null == app){
                result.setCode(0);
                result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
                result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
                return result;
            }
            if(0 == auth){
                List<String> deletelist = new ArrayList<>();
                deletelist.add(app.getAppuuid());
                object.put("deletedApplicationUuids", deletelist);
            }else {
                List<String> addlist = new ArrayList<>();
                addlist.add(app.getAppuuid());
                object.put("addedApplicationUuids",addlist);
            }
            object = SyncImpl.toJSONObject(object);
            String res = HttpUtils.doPost(SsoApi.SSOBaseUrl + SsoApi.AUTHENTICATION + username + SsoApi.TOKEN + token, object, "utf-8");
            result.setData(res);
        }catch (Exception e){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);

        }
        return result;
    }
}
