package com.poly.midware.impl;

import com.alibaba.fastjson.JSONObject;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.impl
 * @Author: longhai
 * @CreateDate: 2018/6/22 9:43
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class SyncImpl {
    public static JSONObject toJSONObject(Object s) {
        String str = JSONObject.toJSONString(s);
        JSONObject object = JSONObject.parseObject(str);
        return object;
    }

    public static boolean successResult(String res) {
        JSONObject obj =JSONObject.parseObject(res);
        if(0 == obj.getInteger("errorNumber")){
            return true;
        }else {
            return false;
        }
    }
}
