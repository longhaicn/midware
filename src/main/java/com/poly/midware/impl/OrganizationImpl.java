package com.poly.midware.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.poly.midware.entity.OrganizationEntity;
import com.poly.midware.entity.sso.SCIMExtendField;
import com.poly.midware.entity.sso.SystemOrganizationSCIM;

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
public class OrganizationImpl {
    public static List<OrganizationEntity> parseJsonAllOrganization(String data) {
        List<OrganizationEntity> list = new ArrayList<>();
        OrganizationEntity entity;
        JSONObject json = JSON.parseObject(data);
        JSONArray ja = (JSONArray) json.get("list");
        for (int i = 0; i < ja.size(); i++) {
            entity = new OrganizationEntity();
            JSONObject jsonObject = ja.getJSONObject(i);
            entity.setOrganizationSetid(jsonObject.getString("organizationSetid"));
            entity.setChildrenOuUuid(jsonObject.getString("childrenOuUuid"));
            entity.setChildrenKey(jsonObject.getString("childrenKey"));
            entity.setCreateTime(jsonObject.getDate("createTime"));
            entity.setOrganizationUuid(jsonObject.getString("organizationUuid"));
            entity.setOrganizationKey(jsonObject.getString("organizationKey"));
            entity.setOrganization(jsonObject.getString("organization"));
            entity.setParentUuid(jsonObject.getString("parentUuid"));
            entity.setParentKey(jsonObject.getString("parentKey"));
            entity.setTs(jsonObject.getDate("ts"));
            entity.setLinkingCode(jsonObject.getString("linkingCode"));
            entity.setArchived(jsonObject.getInteger("archived"));
            list.add(entity);
        }
        return list;
    }

    public static List<SystemOrganizationSCIM> list2Tree(List<OrganizationEntity> list) {
        List<SystemOrganizationSCIM> lists = new ArrayList<>();
        SystemOrganizationSCIM s ;
        List<String> childList ;
        String key;
        try {
            for (OrganizationEntity e : list) {
                s = new SystemOrganizationSCIM();
                key = e.getOrganizationKey().trim();
                childList = new ArrayList<>();

                for (OrganizationEntity o : list) {
                    if(key.equals(o.getParentKey().trim()) && !key.equals(o.getOrganizationKey())){
                        childList.add(o.getOrganizationKey());
                    }
                }

                s.setChildrenOuUuid(childList);
                s.setOrganizationUuid(key);
                s.setOrganization(e.getOrganization());
                s.setParentUuid(e.getParentKey());
                SCIMExtendField extendField = new SCIMExtendField();
                Map<String , Object> map = new HashMap<>();
                map.put("organizationSetid",e.getOrganizationSetid());
                map.put("linkingCode",e.getLinkingCode());
                map.put("ouCode",e.getOrganizationUuid());
                extendField.setAttributes(map);
                s.setExtendField(extendField);
                lists.add(s);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lists;
    }

    public static List<OrganizationEntity> parseJsonInfluenceOrganization(String data) {
        List<OrganizationEntity> list = new ArrayList<>();
        OrganizationEntity entity ;
        JSONObject json = JSON.parseObject(data);
        JSONArray ja = (JSONArray) json.get("list");
        JSONArray jaK = (JSONArray) json.get("listK");
        for (int i = 0; i < ja.size(); i++) {
            entity = new OrganizationEntity();
            JSONObject jsonObject = ja.getJSONObject(i);
            entity.setOrganizationSetid(jsonObject.getString("organizationSetid"));
            entity.setOrganizationUuid(jsonObject.getString("organizationUuid"));
            entity.setOrganizationKey(jsonObject.getString("organizationKey"));
            entity.setOrganization(jsonObject.getString("organization"));
            entity.setParentUuid(jsonObject.getString("parentUuid"));
            entity.setParentKey(jsonObject.getString("parentKey"));
            entity.setChildrenOuUuid(jsonObject.getString("childrenOuUuid"));
            entity.setChildrenKey(jsonObject.getString("childrenKey"));
            entity.setCreateTime(jsonObject.getDate("createTime"));
            entity.setTs(jsonObject.getDate("ts"));
            entity.setLinkingCode(jsonObject.getString("linkingCode"));
            entity.setArchived(jsonObject.getInteger("archived"));
            System.out.println(entity.toString());
            list.add(entity);
        }
        for (int i = 0; i < jaK.size(); i++) {
            entity = new OrganizationEntity();
            JSONObject jsonObject = jaK.getJSONObject(i);
            entity.setOrganizationSetid(jsonObject.getString("organizationSetid"));
            entity.setOrganizationUuid(jsonObject.getString("organizationUuid"));
            entity.setOrganizationKey(jsonObject.getString("organizationKey"));
            entity.setOrganization(jsonObject.getString("organization"));
            entity.setParentUuid(jsonObject.getString("parentUuid"));
            entity.setParentKey(jsonObject.getString("parentKey"));
            entity.setChildrenOuUuid(jsonObject.getString("childrenOuUuid"));
            entity.setChildrenKey(jsonObject.getString("childrenKey"));
            entity.setCreateTime(jsonObject.getDate("createTime"));
            entity.setLinkingCode(jsonObject.getString("linkingCode"));
            entity.setTs(jsonObject.getDate("ts"));
            entity.setArchived(jsonObject.getInteger("archived"));
            list.add(entity);
        }


        return list;
    }

    public static SystemOrganizationSCIM ssoOrganizationParsing(OrganizationEntity entity) {
        SystemOrganizationSCIM ssoOrganization= new SystemOrganizationSCIM();
        ssoOrganization.setOrganizationUuid(entity.getOrganizationKey());
        ssoOrganization.setOrganization(entity.getOrganization());
        ssoOrganization.setParentUuid(entity.getParentKey());
        SCIMExtendField extendField = new SCIMExtendField();
        Map<String , Object> map = new HashMap<>();
        map.put("organizationSetid",entity.getOrganizationSetid());
        map.put("linkingCode",entity.getLinkingCode());
        map.put("ouCode",entity.getOrganizationUuid());
        extendField.setAttributes(map);
        ssoOrganization.setExtendField(extendField);

        return ssoOrganization;
    }
}
