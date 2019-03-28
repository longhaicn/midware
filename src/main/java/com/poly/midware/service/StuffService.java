package com.poly.midware.service;

import com.alibaba.fastjson.JSONObject;
import com.poly.midware.entity.OrganizationEntity;
import com.poly.midware.entity.StuffEntity;
import com.poly.midware.entity.sso.SystemAccountAPIDto;
import com.poly.midware.entity.sso.SystemOrganizationSCIM;
import com.poly.midware.impl.OrganizationImpl;
import com.poly.midware.impl.StuffImpl;
import com.poly.midware.mapper.StuffMapper;
import com.poly.midware.utils.HttpUtils;
import com.poly.midware.utils.TokenUtils;
import com.poly.midware.utils.constant.ExceptionCode;
import com.poly.midware.utils.constant.Message;
import com.poly.midware.utils.constant.SsoApi;
import com.poly.midware.utils.response.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.service
 * @Author: longhai
 * @CreateDate: 2018/5/4 18:16
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class StuffService {
    @Resource
    private StuffMapper stuffMapper;

    //1.查询所有记录
    public JsonResult<List<StuffEntity>> select() {
        JsonResult result = new JsonResult();
        try {
            List<StuffEntity> list = stuffMapper.select();
            result.setData(list);
            result.setRow(list.size());
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    //2.查询条件记录
    public JsonResult<List<StuffEntity>> queryByUserName(String userName) {
        JsonResult result = new JsonResult();
        try {
            List<StuffEntity> list = stuffMapper.queryByUserName(userName);
            result.setData(list);
            result.setRow(list.size());
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    //3.插入一条记录
    public JsonResult<String> insert(StuffEntity stuffEntity) {
        JsonResult result = new JsonResult();
        try {
            int row = stuffMapper.insert(stuffEntity);

            result.setData(Message.INSERTED);
            result.setRow(row);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    //4.更新一条记录
    public JsonResult<String> updateByUserName(StuffEntity stuff) {
        JsonResult result = new JsonResult();
        try {
            int row = stuffMapper.updateByUserName(stuff);
            result.setData(Message.UPDATED);
            result.setRow(row);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    //5.删除一条记录
    public JsonResult<String> deleteByUserName(String userName) {
        JsonResult result = new JsonResult();
        try {
            int row = stuffMapper.deleteByUserName(userName);
            result.setData(Message.DELETED);
            result.setRow(row);
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }
    //6.删除一条记录
    public JsonResult<String> deleteAllStuff() {
        JsonResult result = new JsonResult();
        try {
            int row = stuffMapper.deleteAllStuff();
            result.setData(Message.DELETED);
            result.setRow(row);
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);

        }
        return result;
    }

    public JsonResult<String> archiveAllStuff() {
        JsonResult result = new JsonResult();
        try {
            int row = stuffMapper.archiveAllStuff();
            result.setData(Message.DELETED);
            result.setRow(row);
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    public JsonResult stuffInfluencedSave(String data) {

        JsonResult result = new JsonResult();
        try {
            List<StuffEntity> list =StuffImpl.parseJsonInfluenceStuff(data);
            for (StuffEntity o : list) {
                System.out.println("###stuffInfluencedSave### "+o.toString());
                switch (o.getArchived()){
                    case 1:
                        //1.1判断为新增数据，插入变动表
                        stuffMapper.insertView(o);
                        //1.2插入主表中
                        stuffMapper.insert(o);
                        break;
                    case 2:
                        //2.1判断数据是否存在，存在则修改，不存在则新增
                        System.out.println(200);
                        if(1 == stuffMapper.checkUser(o.getUserName()).getNumber()) {
                            //插入变动表
                            stuffMapper.insertView(o);
                            //更新主表
                            o.setArchived(0);
                            stuffMapper.updateByUserName(o);
                        }else {
                            //插入变动表
                            o.setArchived(1);
                            stuffMapper.insertView(o);
                            //插入主表
                            o.setArchived(0);
                            stuffMapper.insert(o);
                        }
                        break;
                    case 3:
                        //插入变动表
                        stuffMapper.insertView(o);
                        //修改主表
                        stuffMapper.archiveByUserName(o.getUserName());
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    public JsonResult<String> ssoStuffPushAll() {
        String token = TokenUtils.getToken();
        JsonResult result = new JsonResult();
        try {
            List<StuffEntity> list = stuffMapper.ssoStuffPushAll();
            int i=0;
            for (StuffEntity entity:list) {
                i++;
                if (i>15){
                    break;
                }
                System.out.println(entity.toString());
                SystemAccountAPIDto s = StuffImpl.ssoStuffParsing(entity);
                String str = JSONObject.toJSONString(s);
                JSONObject object = JSONObject.parseObject(str);
                String res = HttpUtils.doPost(SsoApi.SSOBaseUrl+SsoApi.ACCOUNT+SsoApi.TOKEN+token,object,"utf-8");
                System.out.println(res);
                result.setData(res);
            }
            result.setRow(list.size());
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }


    public JsonResult<String> ssoStuffPushPartial() {
        String token = TokenUtils.getToken();
        JsonResult result = new JsonResult();
        try {
            List<StuffEntity> list = stuffMapper.ssoStuffPushPartial();
            for (StuffEntity entity : list) {
                if(1 == entity.getArchived()){
                    SystemAccountAPIDto s = StuffImpl.ssoStuffParsing(entity);
                    String str = JSONObject.toJSONString(s);
                    JSONObject object = JSONObject.parseObject(str);
                    String res = HttpUtils.doPost(SsoApi.SSOBaseUrl+SsoApi.ACCOUNT+SsoApi.TOKEN+token,object,"utf-8");
                    result.setData(res);
                    JSONObject obj =JSONObject.parseObject(res);
                    if(0 == obj.getInteger("errorNumber")){
                        stuffMapper.success(entity.getUserName(),11);
                    }
                }else if(2 == entity.getArchived()){
                    SystemAccountAPIDto s = StuffImpl.ssoStuffParsing(entity);
                    String str = JSONObject.toJSONString(s);
                    JSONObject object = JSONObject.parseObject(str);
                    String res = HttpUtils.doPut(SsoApi.SSOBaseUrl+SsoApi.ACCOUNT+SsoApi.TOKEN+token,object,"utf-8");
                    result.setData(res);
                    JSONObject obj =JSONObject.parseObject(res);
                    if(0 == obj.getInteger("errorNumber")){
                        stuffMapper.success(entity.getUserName(),12);
                    }
                }else if(3 == entity.getArchived()){
                    SystemAccountAPIDto s = StuffImpl.ssoStuffParsing(entity);
                    String res =HttpUtils.doDelete(SsoApi.SSOBaseUrl+SsoApi.ACCOUNT+SsoApi.TOKEN+token+"&id="+s.getId(),"utf-8");
                    result.setData(res);
                    JSONObject obj =JSONObject.parseObject(res);
                    if(0 == obj.getInteger("errorNumber")){
                        stuffMapper.success(entity.getUserName(),13);
                    }
                }
            }

        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;
    }

    public JsonResult<String> ssoStuffReset() {
        String token = TokenUtils.getToken();
        JsonResult result = new JsonResult();
        try {
            List<StuffEntity> list = stuffMapper.ssoStuffPushAll();
            int i=0;
            for (StuffEntity entity:list) {
                i++;
                if (i>15){
                    break;
                }
                System.out.println(entity.toString());
                SystemAccountAPIDto s = StuffImpl.ssoStuffParsing(entity);
                String res = HttpUtils.doDelete(SsoApi.SSOBaseUrl + SsoApi.ACCOUNT + SsoApi.TOKEN + token + "&id=" + s.getId(), "utf-8");
                System.out.println(res);
                result.setData(res);
            }
            result.setRow(list.size());
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(ExceptionCode.EXCEPTION_MSG_4000);
            result.setExpCode(ExceptionCode.EXCEPTION_CODE_4000);
        }
        return result;



    }
}
