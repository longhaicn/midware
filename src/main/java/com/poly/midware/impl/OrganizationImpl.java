package com.poly.midware.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.poly.midware.entity.OrganizationEntity;
import com.poly.midware.entity.OrganizationTreeEntity;
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
        OrganizationEntity entity ;
        JSONObject json = JSON.parseObject(data);
        JSONArray ja = (JSONArray) json.get("list");
        for (int i = 0; i < ja.size(); i++) {
            entity = new OrganizationEntity();
            JSONObject jsonObject = ja.getJSONObject(i);
            entity.setUniqueId(jsonObject.getString("uniqueId"));
            entity.setOrganizationSetid(jsonObject.getString("organizationSetid"));
            entity.setChildrenOuUuid(jsonObject.getString("childrenOuUuid"));
            entity.setCreateTime(jsonObject.getDate("createTime"));
            entity.setOrganizationUuid(jsonObject.getString("organizationUuid"));
            entity.setOrganization(jsonObject.getString("organization"));
            entity.setParentUuid(jsonObject.getString("parentUuid"));
            entity.setTs(jsonObject.getDate("ts"));
            entity.setLinkingCode(jsonObject.getString("linkingCode"));
            entity.setArchived(jsonObject.getInteger("archived"));
            list.add(entity);
        }
        return list;
    }

    public static Map<String, List<OrganizationEntity>> parseJsonInfluenceOrganization(String data) {
        Map<String, List<OrganizationEntity>> map = new HashMap<String, List<OrganizationEntity>>();

        List<OrganizationEntity> listNew = new ArrayList<>();
        List<OrganizationEntity> listDelete = new ArrayList<>();
        List<OrganizationEntity> listUpdate = new ArrayList<>();

        OrganizationEntity entity ;
        JSONObject json = JSON.parseObject(data);
        JSONArray ja = (JSONArray) json.get("list");
        JSONArray jaK = (JSONArray) json.get("listK");
        for (int i = 0; i < ja.size(); i++) {
            entity = new OrganizationEntity();
            JSONObject jsonObject = ja.getJSONObject(i);

            int flag = jsonObject.getInteger("archived");


            entity.setUniqueId(jsonObject.getString("uniqueId"));
            entity.setOrganizationSetid(jsonObject.getString("organizationSetid"));
            entity.setChildrenOuUuid(jsonObject.getString("childrenOuUuid"));
            entity.setCreateTime(jsonObject.getDate("createTime"));
            entity.setOrganizationUuid(jsonObject.getString("organizationUuid"));
            entity.setOrganization(jsonObject.getString("organization"));
            entity.setParentUuid(jsonObject.getString("parentUuid"));
            entity.setTs(jsonObject.getDate("ts"));
            entity.setLinkingCode(jsonObject.getString("linkingCode"));
            entity.setArchived(0);

            if(1 == flag){
                listNew.add(entity);
            }else if(2 == flag){
                listUpdate.add(entity);
            }else if (3 == flag){
                listDelete.add(entity);
            }
        }

        for (int i = 0; i < jaK.size(); i++) {
            entity = new OrganizationEntity();
            JSONObject jsonObject = jaK.getJSONObject(i);

            int flag = jsonObject.getInteger("archived");
            entity.setOrganizationUuid(jsonObject.getString("organizationUuid"));
            entity.setOrganization(jsonObject.getString("organization"));
            entity.setParentUuid(jsonObject.getString("parentUuid"));
            entity.setTs(jsonObject.getDate("ts"));
            entity.setLinkingCode(jsonObject.getString("linkingCode"));
            entity.setUniqueId(jsonObject.getString("uniqueId"));
            entity.setOrganizationSetid(jsonObject.getString("organizationSetid"));
            entity.setChildrenOuUuid(jsonObject.getString("childrenOuUuid"));
            entity.setCreateTime(jsonObject.getDate("createTime"));

            entity.setArchived(0);

            if(1 == flag){
                listNew.add(entity);
            }else if (3 == flag){
                listDelete.add(entity);
            }else if(2 == flag){
                listUpdate.add(entity);
            }
        }

        map.put("New",listNew);
        map.put("Delete",listDelete);
        map.put("Update",listUpdate);
        return map;
    }
    public static List<SystemOrganizationSCIM> list2Tree(List<OrganizationEntity> list) {
        List<SystemOrganizationSCIM> lists = new ArrayList<>();
        SystemOrganizationSCIM s ;
        List<String> childList ;
        String id;
        try {
            for (OrganizationEntity e : list) {
                s = new SystemOrganizationSCIM();
                id = e.getOrganizationUuid().trim();
                childList = new ArrayList<>();

                for (OrganizationEntity o : list) {
                    if(id.equals(o.getParentUuid().trim()) && !id.equals(o.getOrganizationUuid())){
                        childList.add(o.getOrganizationUuid());
                    }
                }

                s.setChildrenOuUuid(childList);
                s.setOrganizationUuid(id);
                s.setOrganization(e.getOrganization());
                s.setParentUuid(e.getParentUuid());
                SCIMExtendField extendField = new SCIMExtendField();
                Map<String , Object> map = new HashMap<>();
                map.put("organizationSetid",e.getOrganizationSetid());
                map.put("linkingCode",e.getLinkingCode());
                extendField.setAttributes(map);
                s.setExtendField(extendField);
                lists.add(s);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return lists;
    }

    public static  List<OrganizationTreeEntity> parseList2Tree(List<OrganizationEntity> list) {
        List<OrganizationTreeEntity> root =new ArrayList<>();
        OrganizationTreeEntity t = new OrganizationTreeEntity();
        for (OrganizationEntity entity:list) {
            if (entity.getOrganizationUuid().equals(entity.getParentUuid())){
                t.setOrganizationUuid(entity.getOrganizationUuid());
                t.setOrganization(entity.getOrganization());
                root.add(t);
                System.out.println(t.toString());
            }
        }
        return  buildTree(root,list);
    }

    public static List<OrganizationTreeEntity> buildTree( List<OrganizationTreeEntity> listTree,List<OrganizationEntity> list){

        List<OrganizationTreeEntity> root =new ArrayList<>();
        for (OrganizationTreeEntity tr: listTree) {
            List<OrganizationTreeEntity> child = getChildList(tr,list);
            if(null == child){
                tr.setChildrenOuUuidList(child);
            }else {
                break;
            }
        }
        return  buildTree(root,list);
    }

    private static List<OrganizationTreeEntity> getChildList(OrganizationTreeEntity tree,List<OrganizationEntity> list) {
        List<OrganizationTreeEntity> listTree = new ArrayList<>();
        OrganizationTreeEntity t = new OrganizationTreeEntity();
        for (OrganizationEntity entity: list) {
            if(tree.getOrganizationUuid().equals(entity.getParentUuid()) && !tree.getOrganizationUuid().equals(entity.getOrganizationUuid())){
                t.setOrganizationUuid(entity.getOrganizationUuid());
                t.setOrganization(entity.getOrganization());
                listTree.add(t);
            }
        }
        return listTree;
    }


    public static SystemOrganizationSCIM parseOrganization(OrganizationEntity e) {

        List<SystemOrganizationSCIM> lists = new ArrayList<>();
        SystemOrganizationSCIM s ;
        List<String> childList ;
        String id;
        s = new SystemOrganizationSCIM();
        id = e.getOrganizationUuid().trim();
        childList = new ArrayList<>();


        s.setChildrenOuUuid(childList);
        s.setOrganizationUuid(id);
        s.setOrganization(e.getOrganization());

        SCIMExtendField extendField = new SCIMExtendField();
        Map<String , Object> map = new HashMap<>();
        map.put("organizationSetid",e.getOrganizationSetid());
        map.put("linkingCode",e.getLinkingCode());
        extendField.setAttributes(map);
        s.setExtendField(extendField);

        return s;
    }
}
