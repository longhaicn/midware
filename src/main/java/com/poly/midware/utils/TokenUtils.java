package com.poly.midware.utils;

import com.alibaba.fastjson.JSONObject;
import com.poly.midware.utils.constant.SsoApi;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.utils
 * @Author: longhai
 * @CreateDate: 2018/6/4 10:04
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class TokenUtils {
    public static String getToken() {

        String url = SsoApi.SSOBaseUrl+"/oauth/token?client_id=6344cc5290984343edf589f0f403706arFdIMEyZbTQ&client_secret=9FG885AHpV7yL3ldVinfHBIb9LZLckVp3YKf33REM9&scope=read&grant_type=client_credentials";
//        String url = SsoApi.SSOBaseUrl+"/oauth/token?client_id=0fa2f9534d47cd92125657360b5cf019lEVinbZpohY&client_secret=k6Ex0otzR5HhPhJNnBF4rXPq2UdpkQ4zz8Sy0X76JA&scope=read&grant_type=client_credentials";

//        String url = SsoApi.SSOBaseUrl+"/oauth/token?client_id=5965928c95143dc29620f040bf73e25eqM3cAIBzQwB&client_secret=rPHOnIcwKG3XgaL3p73Jzy9yVwBFwcoTI4E42qh9uL&scope=read&grant_type=client_credentials";
        String token = HttpUtils.doPost(url,"utf-8");
        token = JSONObject.parseObject(token).getString("access_token");
        System.out.println(token);
        return token;
    }
}
