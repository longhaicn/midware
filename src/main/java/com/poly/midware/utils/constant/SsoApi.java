package com.poly.midware.utils.constant;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.utils.constant
 * @Author: longhai
 * @CreateDate: 2018/6/4 15:40
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class SsoApi {
    /**IPG提供API地址*/
    public static final String SSOBaseUrl="http://sso.shenzhenpoly.com";//http://192.168.10.129
    /**组织机构*/
    public static final String ORGANIZATION="/api/application/scim/organization";
    /**人员*/
    public static final String ACCOUNT="/api/application/scim/account";
    /**账户应用授权*/
    public static final String AUTHENTICATION="/api/application/user/auth_";
    /**Token拼接*/
    public static final String TOKEN = "?access_token=";
}
