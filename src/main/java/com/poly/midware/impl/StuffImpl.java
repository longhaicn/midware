package com.poly.midware.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.poly.midware.entity.StuffEntity;
import com.poly.midware.entity.sso.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.impl
 * @Author: longhai
 * @CreateDate: 2018/5/31 16:42
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class StuffImpl {
    public static List<StuffEntity> parseJsonAllStuff(String data) {
        List<StuffEntity> list = new ArrayList<>();
        StuffEntity entity = null;
        JSONObject json = JSON.parseObject(data);
        JSONArray ja = (JSONArray) json.get("list");
        for (int i = 0; i < ja.size(); i++) {
            entity = new StuffEntity();
            JSONObject jsonObject = ja.getJSONObject(i);
            entity.setUserName(jsonObject.getString("userName"));
            entity.setDisplayName(jsonObject.getString("displayName"));
            entity.setGender(jsonObject.getString("gender"));
            entity.setPinyinName(jsonObject.getString("pinyinName"));
            entity.setEmails(jsonObject.getString("emails"));
            entity.setPhoneNumber(jsonObject.getString("phoneNumber"));
            entity.setLeader(jsonObject.getString("leader"));
            entity.setIdCard(jsonObject.getString("idCard"));
            entity.setStatus(jsonObject.getString("status"));
            entity.setJobKey(jsonObject.getString("jobKey"));
            entity.setJobName(jsonObject.getString("jobName"));
            entity.setJobGrade(jsonObject.getString("jobGrade"));
            entity.setOrganizationKey(jsonObject.getString("organizationKey"));
            entity.setOrganizationName(jsonObject.getString("organizationName"));
            entity.setCreateTime(jsonObject.getDate("createTime"));
            entity.setTs(jsonObject.getDate("ts"));
            entity.setArchived(jsonObject.getInteger("archived"));
            entity.setRole("0");
            list.add(entity);
        }
        return list;
    }
    public static List<StuffEntity> parseJsonInfluenceStuff(String data) {
        List<StuffEntity> list = new ArrayList<>();
        StuffEntity entity = null;
        JSONObject json = JSON.parseObject(data);
        JSONArray ja = (JSONArray) json.get("list");
        for (int i = 0; i < ja.size(); i++) {
            entity = new StuffEntity();
            JSONObject jsonObject = ja.getJSONObject(i);
            entity.setUserName(jsonObject.getString("userName"));
            entity.setGender(jsonObject.getString("gender"));
            entity.setIdCard(jsonObject.getString("idCard"));
            entity.setStatus(jsonObject.getString("status"));
            entity.setJobKey(jsonObject.getString("jobKey"));
            entity.setJobName(jsonObject.getString("jobName"));
            entity.setJobGrade(jsonObject.getString("jobGrade"));
            entity.setOrganizationKey(jsonObject.getString("organizationKey"));
            entity.setOrganizationName(jsonObject.getString("organizationName"));
            entity.setDisplayName(jsonObject.getString("displayName"));
            entity.setPinyinName(jsonObject.getString("pinyinName"));
            entity.setEmails(jsonObject.getString("emails"));
            entity.setPhoneNumber(jsonObject.getString("phoneNumber"));
            entity.setLeader(jsonObject.getString("leader"));
            entity.setCreateTime(jsonObject.getDate("createTime"));
            entity.setTs(jsonObject.getDate("ts"));
            entity.setArchived(jsonObject.getInteger("archived"));
            entity.setRole("0");//臻家默认角色

            list.add(entity);
        }
        return list;
    }

    public static SystemAccountAPIDto ssoStuffParsing(StuffEntity entity) {
        SystemAccountAPIDto systemAccountAPIDto = new SystemAccountAPIDto();
        Belongs belongs = new Belongs();
        EmailSCIM emailSCIM = new EmailSCIM();
        List<Belongs> listBelongs = new ArrayList<>();
        List<EmailSCIM> listEmailSCIM = new ArrayList<>();
        SCIMExtendField listSCIMExtendField = new SCIMExtendField();
        PhoneNumberSCIM phoneNumberSCIM = new PhoneNumberSCIM();
        List<PhoneNumberSCIM> listPhoneNumberSCIM = new ArrayList<>();
        systemAccountAPIDto.setDisplayName(entity.getDisplayName());
        belongs.setBelongOuUuid(entity.getOrganizationKey());
        listBelongs.add(belongs);
        systemAccountAPIDto.setBelongs(listBelongs);
        emailSCIM.setValue(entity.getEmails());
        listEmailSCIM.add(emailSCIM);
        systemAccountAPIDto.setEmails(listEmailSCIM);
        Map<String,Object> map = new HashMap<>();
        map.put("role",entity.getRole());
        map.put("gender",entity.getGender());
        map.put("status",entity.getStatus());
        map.put("leader",entity.getLeader());
        map.put("jobKey",entity.getJobKey());
        map.put("jobGrade",entity.getJobGrade());
        map.put("jobName",entity.getJobName());
        map.put("pinyinName",entity.getPinyinName());
        map.put("idCard",entity.getIdCard());
        map.put("organizationName",entity.getOrganizationName());
        listSCIMExtendField.setAttributes(map);
        systemAccountAPIDto.setExtendField(listSCIMExtendField);
        systemAccountAPIDto.setExternalId(entity.getUserName());
        systemAccountAPIDto.setId(entity.getUserName());
        systemAccountAPIDto.setUserName(entity.getUserName());
        phoneNumberSCIM.setValue(entity.getPhoneNumber());
        listPhoneNumberSCIM.add(phoneNumberSCIM);
        systemAccountAPIDto.setPhoneNumbers(listPhoneNumberSCIM);
        return  systemAccountAPIDto;
    }


}

