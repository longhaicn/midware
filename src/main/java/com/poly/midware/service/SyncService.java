package com.poly.midware.service;

import com.alibaba.fastjson.JSONObject;
import com.poly.midware.entity.OrganizationEntity;
import com.poly.midware.entity.StuffEntity;
import com.poly.midware.entity.sso.SystemAccountAPIDto;
import com.poly.midware.entity.sso.SystemOrganizationSCIM;
import com.poly.midware.impl.OrganizationImpl;
import com.poly.midware.impl.StuffImpl;
import com.poly.midware.impl.SyncImpl;
import com.poly.midware.mapper.SyncMapper;
import com.poly.midware.utils.HttpUtils;
import com.poly.midware.utils.TokenUtils;
import com.poly.midware.utils.constant.SsoApi;
import com.poly.midware.utils.response.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.service
 * @Author: longhai
 * @CreateDate: 2018/6/22 9:19
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class SyncService {
    @Resource
    private SyncMapper syncMapper;

    public JsonResult<String> syncEvent() {
        String token = TokenUtils.getToken();
        JsonResult result = new JsonResult();
        SystemOrganizationSCIM ssoOrganization;
        SystemAccountAPIDto ssoStuff;
        JSONObject object;
        try {
            //获取组织架构的新增和更新信息
            List<OrganizationEntity> pOrganizationList = syncMapper.pOrganizationList();
            //获取人员的新增，更新，删除信息
            List<StuffEntity> stuffList = syncMapper.stuffList();
            //获取组织机构的删除信息
            List<OrganizationEntity> vOrganizationList = syncMapper.vOrganizationList();
            //新增 更新 组织架构
            for (OrganizationEntity entity : pOrganizationList) {
                ssoOrganization = OrganizationImpl.ssoOrganizationParsing(entity);
                object = SyncImpl.toJSONObject(ssoOrganization);
                if (1 == entity.getArchived()) {//新增

                    String res = HttpUtils.doPost(SsoApi.SSOBaseUrl + SsoApi.ORGANIZATION + SsoApi.TOKEN + token, object, "utf-8");
                    System.out.println("insert" + res);
                    if (SyncImpl.successResult(res)) {
                        syncMapper.successOrg(entity.getOrganizationKey(), 11);
                    }

                } else if (2 == entity.getArchived()) {

                    String res = HttpUtils.doPut(SsoApi.SSOBaseUrl + SsoApi.ORGANIZATION + SsoApi.TOKEN + token, object, "utf-8");
                    System.out.println("update" + res);
                    if (SyncImpl.successResult(res)) {
                        syncMapper.successOrg(entity.getOrganizationKey(), 12);
                    }
                }
            }
            //新增 更新 删除人员
            for (StuffEntity entity : stuffList) {
                ssoStuff = StuffImpl.ssoStuffParsing(entity);
                object = SyncImpl.toJSONObject(ssoStuff);
                if (1 == entity.getArchived()) {
                    String res = HttpUtils.doPost(SsoApi.SSOBaseUrl + SsoApi.ACCOUNT + SsoApi.TOKEN + token, object, "utf-8");
                    result.setData(res);
                    if (SyncImpl.successResult(res)) {
                        syncMapper.successStf(entity.getUserName(), 11);
                    }
                } else if (2 == entity.getArchived()) {
                    String res = HttpUtils.doPut(SsoApi.SSOBaseUrl + SsoApi.ACCOUNT + SsoApi.TOKEN + token, object, "utf-8");
                    result.setData(res);
                    if (SyncImpl.successResult(res)) {
                        syncMapper.successStf(entity.getUserName(), 12);
                    }
                } else if (3 == entity.getArchived()) {
                    String res = HttpUtils.doDelete(SsoApi.SSOBaseUrl + SsoApi.ACCOUNT + SsoApi.TOKEN + token + "&id=" + ssoStuff.getId(), "utf-8");
                    result.setData(res);
                    if (SyncImpl.successResult(res)) {
                        syncMapper.successStf(entity.getUserName(), 13);
                    }
                }
            }
            //删除组织架构
            for (OrganizationEntity entity : vOrganizationList) {
                if (3 == entity.getArchived()) {
                    String url = SsoApi.SSOBaseUrl + SsoApi.ORGANIZATION + SsoApi.TOKEN + token + "&id=" + entity.getOrganizationKey();
                    String res = HttpUtils.doDelete(url, "utf-8");
                    System.out.println("delete" + res);
                    if (SyncImpl.successResult(res)) {
                        syncMapper.successOrg(entity.getOrganizationKey(), 13);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
