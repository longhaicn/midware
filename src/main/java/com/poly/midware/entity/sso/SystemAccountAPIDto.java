package com.poly.midware.entity.sso;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaofei Du on 2017/3/29.
 */
@Data
public class SystemAccountAPIDto implements Serializable{
    private static final long serialVersionUID = 772709955971591838L;
    /**
     * 主账户(必选)
     */
    private String userName;
    /**
     * 昵称，唯一
     */
    private String displayName;
    /**
     * 密码(必选)
     */
    private String password;

    /**
     * id,唯一
     */
    private String id;
    /**
     * 外部ID，唯一
     */
    private String externalId;

    /**
     * 邮箱
     */
    private List<EmailSCIM> emails = new ArrayList<>();
    /**
     * 手机号
     */
    private List<PhoneNumberSCIM> phoneNumbers = new ArrayList<>();

    //所属OU
    private List<Belongs> belongs = new ArrayList<>();

    /**
     * IDP之间互相同步时加的字段，为密码使用
     * 当该字段为false时，代表密码是hash过的密码，可以直接保存
     */
    private boolean originalPass = true;

//    private String masterSalt;

    private String masterSecret;
    /**
     * SCIM同步扩展字段类,以后只要是同步需要扩展字段的,都放在这个类里面.
     */
    private SCIMExtendField extendField;

    //是否被锁定
    private boolean locked;

}
