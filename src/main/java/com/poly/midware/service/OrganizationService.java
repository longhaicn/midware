package com.poly.midware.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.poly.midware.entity.OrganizationEntity;
import com.poly.midware.entity.sso.SCIMExtendField;
import com.poly.midware.entity.sso.SystemOrganizationSCIM;
import com.poly.midware.impl.OrganizationImpl;
import com.poly.midware.mapper.OrganizationMapper;
import com.poly.midware.utils.HttpUtils;
import com.poly.midware.utils.TokenUtils;
import com.poly.midware.utils.constant.ExceptionCode;
import com.poly.midware.utils.constant.Message;
import com.poly.midware.utils.constant.SsoApi;
import com.poly.midware.utils.response.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.service
 * @Author: longhai
 * @CreateDate: 2018/5/4 18:16
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    //1.插入一条记录
    public JsonResult<String> insert(OrganizationEntity organizationEntity) {

        JsonResult result = new JsonResult();
        try {
//            String token = TokenUtils.getToken();
            int row = organizationMapper.insert(organizationEntity);
//            String url=SsoApi.SSOBaseUrl+SsoApi.ORGANIZATION+SsoApi.TOKEN+token;
//            String res = HttpUtils.doPost(url, JSONObject.parseObject(JSONArray.toJSON(organizationEntity).toString()),"utf-8");
//            System.out.println(res);
            if (row > 0) {
                result.setRow(row);
                result.setData(Message.INSERTED);
            }
            System.out.println(result);
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    //2.查询所有记录
    public JsonResult<List<OrganizationEntity>> select() {
        JsonResult result = new JsonResult();
        try {
            List<OrganizationEntity> list = organizationMapper.select();
            result.setData(list);
            result.setRow(list.size());
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }


        return result;
    }

    //2.1 查询所有记录 UM UN
    public JsonResult<List<OrganizationEntity>> selectUMUN() {
        JsonResult result = new JsonResult();
        try {
            List<OrganizationEntity> list = organizationMapper.selectUMUN();
            result.setData(list);
            result.setRow(list.size());
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }


        return result;
    }

    //3.查询条件记录
    public JsonResult<List<OrganizationEntity>> queryByOrganizationUuid(String organizationUuid) {
        JsonResult result = new JsonResult();
        try {
            List<OrganizationEntity> list = organizationMapper.queryByOrganizationUuid(organizationUuid);
            result.setData(list);
            result.setRow(list.size());
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    //4.更新一条记录
    public JsonResult<String> updateByOrganizationUuid(OrganizationEntity o) {

        JsonResult result = new JsonResult();
        try {
            int row = organizationMapper.updateByOrganizationUuid(o.getOrganizationSetid(),o.getOrganizationUuid(),o.getOrganization(),o.getParentUuid(),o.getLinkingCode(),o.getCreateTime(),o.getTs(),o.getUniqueId());
//            int row = organizationMapper.updateByOrganizationUuid(o);
            result.setData(Message.UPDATED);
            result.setRow(row);

        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
            result.setData(e.getMessage());
        }
        return result;

    }

    //5.删除一条记录
    public JsonResult<String> deleteByOrganizationUuid(String organizationUuid) {
        JsonResult result = new JsonResult();
        try {
            int row = organizationMapper.deleteByOrganizationUuid(organizationUuid);
            if (row > 0) {
                result.setRow(row);
                result.setData(Message.DELETED);
            }
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;

    }
    //5.删除所有记录
    public JsonResult<String> deleteAllOrganization() {
        JsonResult result = new JsonResult();
        try {
            int row = organizationMapper.deleteAllOrganization();
            if (row > 0) {
                result.setRow(row);
                result.setData(Message.DELETED);
            }
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;

    }

    public JsonResult<String> archiveAllOrganization() {
        JsonResult result = new JsonResult();
        try {
            int row = organizationMapper.archiveAllOrganization();
            if (row > 0) {
                result.setRow(row);
                result.setData(Message.DELETED);
            }
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    public JsonResult<String> organizationInfluenced(List<OrganizationEntity> listNew, List<OrganizationEntity> listDelete, List<OrganizationEntity> listUpdate) {
        JsonResult result = new JsonResult();
        Date date = new Date();
        String token = TokenUtils.getToken();
        String url = "";
        try {
            for (OrganizationEntity o : listUpdate) {
                int count = organizationMapper.check(o.getUniqueId()).getNumber();
                System.out.println("count="+count);
                if(1 == count){
                    organizationMapper.updateByOrganizationUuid(o.getOrganizationSetid(),o.getOrganizationUuid(),o.getOrganization(),o.getParentUuid(),o.getLinkingCode(),o.getCreateTime(),o.getTs(),o.getUniqueId());
                    o.setTs(date);
                    o.setArchived(2);
                    organizationMapper.insertOrganizationView(o);

                }else if(0 == count){
                    System.out.println(0);
                    listNew.add(o);
                }
            }

            for (OrganizationEntity e : listNew) {
                int count = organizationMapper.check(e.getUniqueId()).getNumber();
                System.out.println("count="+count);
                if(0 == count){
                    organizationMapper.insert(e);
                    e.setTs(date);
                    e.setArchived(1);
                    organizationMapper.insertOrganizationView(e);

                }else {
                    System.out.println(10);
                }
            }

            for (OrganizationEntity e : listDelete) {
                int count = organizationMapper.check(e.getUniqueId()).getNumber();
                System.out.println("count="+count);
                if(1 == count){
                    organizationMapper.deleteByOrganizationUuid(e.getUniqueId());
                    e.setTs(date);
                    e.setArchived(3);
                    organizationMapper.insertOrganizationView(e);
                }else {
                    System.out.println(20);
                }
            }
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    public JsonResult<List<OrganizationEntity>> selectTreeUMUN() {
        JsonResult result = new JsonResult();
        try {
            List<OrganizationEntity> list = organizationMapper.selectUMUN();
            result.setData(OrganizationImpl.parseList2Tree(list));
            result.setRow(list.size());
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(e.getMessage());
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    public JsonResult<String> ssoOrganizationPushAll() {
        String token = TokenUtils.getToken();
        JsonResult result = new JsonResult();
        try {
            List<OrganizationEntity> list = organizationMapper.select();
            List<SystemOrganizationSCIM> lists = OrganizationImpl.list2Tree(list);
            int i = 0;
            for (SystemOrganizationSCIM s:lists){

                i++;
                String str = JSONObject.toJSONString(s);
                JSONObject object = JSONObject.parseObject(str);
                String res = HttpUtils.doPost(SsoApi.SSOBaseUrl+SsoApi.ORGANIZATION+SsoApi.TOKEN+token,object,"utf-8");
                System.out.println("有妈的孩子：i="+i+","+res);
                result.setData(res);
            }
            result.setRow(lists.size());
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    private boolean hasParentOU(String s) {
        OrganizationEntity organizationEntity = organizationMapper.queryOrganizationByUuid(s);

        if (null == organizationEntity ){
            System.out.println(s);
            return true;
        }else if(organizationEntity.getOrganizationUuid().equals(organizationEntity.getParentUuid())) {
            return false;
        }else{
           return hasParentOU(organizationEntity.getParentUuid());
        }
    }
    public JsonResult<String> ssoOrganizationPushPartial(){
        String token = TokenUtils.getToken();
        JsonResult result = new JsonResult();
        SystemOrganizationSCIM s = new SystemOrganizationSCIM();
        try {
            List<OrganizationEntity> listUpdate = organizationMapper.ssoOrganizationPushPartial();
            for (OrganizationEntity entity: listUpdate ){
                if(1 == entity.getArchived()){//新增
                    s.setOrganizationUuid(entity.getOrganizationUuid());
                    s.setOrganization(entity.getOrganization());
                    s.setParentUuid(entity.getParentUuid());
                    SCIMExtendField extendField = new SCIMExtendField();
                    Map<String , Object> map = new HashMap<>();
                    map.put("organizationSetid",entity.getOrganizationSetid());
                    map.put("linkingCode",entity.getLinkingCode());
                    extendField.setAttributes(map);
                    s.setExtendField(extendField);
                    String str = JSONObject.toJSONString(s);
                    JSONObject object = JSONObject.parseObject(str);
                    String res = HttpUtils.doPost(SsoApi.SSOBaseUrl+SsoApi.ORGANIZATION+SsoApi.TOKEN+token,object,"utf-8");
                    System.out.println("insert"+res);
                }else if(2 == entity.getArchived()){
                    s.setOrganizationUuid(entity.getOrganizationUuid());
                    s.setOrganization(entity.getOrganization());
                    s.setParentUuid(entity.getParentUuid());
                    SCIMExtendField extendField = new SCIMExtendField();
                    Map<String , Object> map = new HashMap<>();
                    map.put("organizationSetid",entity.getOrganizationSetid());
                    map.put("linkingCode",entity.getLinkingCode());
                    extendField.setAttributes(map);
                    String str = JSONObject.toJSONString(s);
                    JSONObject object = JSONObject.parseObject(str);
                    System.out.println(entity.toString());
                    String res = HttpUtils.doPut(SsoApi.SSOBaseUrl+SsoApi.ORGANIZATION+SsoApi.TOKEN+token,object,"utf-8");
                    System.out.println("update"+res);
                }else if(3 == entity.getArchived()){
                    System.out.println(entity.toString());
                    String url =SsoApi.SSOBaseUrl+SsoApi.ORGANIZATION+SsoApi.TOKEN+token+"&id="+entity.getOrganizationUuid();
                    String res =HttpUtils.doDelete(url,"utf-8");
                    System.out.println(url);
                    System.out.println("delete"+res);
                }
            }

        } catch (Exception e){
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;





    }
}
