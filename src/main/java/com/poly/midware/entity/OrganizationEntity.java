package com.poly.midware.entity;

import java.util.List;

/**
 * 组织架构实体
 */
public class OrganizationEntity {
    /**数据库流水*/
    private String ids;
    /**组织机构的ID*/
    private String organizationUuid;
    /**组织机构名称*/
    private  String organization;
    /**所属父级组织机构的ID*/
    String parentUuid;
    /**OU的所有直属子级*/
    private List<String> childrenOuUuid;
    /**创建时间*/
    private String createTime;
    /**最后操作时间*/
    private  String ts;
    /**删除标记*/
    private String archived;
    /**是否已同步*/
    private String handleFlag;
    /**是否同步成功*/
    private String success;
    /**同步失败，原因*/
    private String errorInfo;
    /**推送次数记录*/
    private  String pushNumber;

}
