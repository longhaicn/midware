package com.poly.midware.api.authentication;

import com.alibaba.fastjson.JSONObject;
import com.poly.midware.impl.SyncImpl;
import com.poly.midware.utils.HttpUtils;
import com.poly.midware.utils.TokenUtils;
import com.poly.midware.utils.constant.SsoApi;
import com.poly.midware.utils.response.JsonResult;

import java.util.ArrayList;
import java.util.List;

public class AuthInfoController {

    public JsonResult<String> authernticate() {
        String token = TokenUtils.getToken();
        JsonResult result = new JsonResult();
        JSONObject object = new JSONObject();
        String username = "18032219";

//        String addedApplicationUuids[] = {};
//        String deletedApplicationUuids[] = {"7dbd6fde37463c70bb571054c7ed8b195R9wZvFLDDm","4b45f96e2b6775427571bc9436a43139PUm2J4NiLRx"};

        List<String> addlist = new ArrayList<>();
        List<String> deletelist = new ArrayList<>();
//
        addlist.add("7dbd6fde37463c70bb571054c7ed8b195R9wZvFLDDm");
        addlist.add("4b45f96e2b6775427571bc9436a43139PUm2J4NiLRx");

        object.put("addedApplicationUuids",addlist);
        object.put("deletedApplicationUuids", deletelist);

        object = SyncImpl.toJSONObject(object);

        String res = HttpUtils.doPost(SsoApi.SSOBaseUrl + SsoApi.AUTHENTICATION + username + SsoApi.TOKEN + token, object, "utf-8");
        System.out.println(res);

        return result;
    }
}
