package com.poly.midware.entity;
import lombok.Data;
import java.util.Date;

/**
 * 组织架构实体
 */
@Data
public class OrganizationEntity implements java.io.Serializable {
    /**
     * 数据库流水
     */
//    private int id;
    /**
     * 数据唯一标识ID
     */
    private String uniqueId;
    /**
     * 机构类型：单位:UN  部门:UM   岗位:@K
     */
    private String organizationSetid;
    /**
     * 组织机构的ID
     */
    private String organizationUuid;
    /**
     * 组织机构名称
     */
    private String organization;
    /**
     * 所属父级组织机构的ID
     */
    private String parentUuid;
    /**
     * OU的所有直属子级
     */
    private String childrenOuUuid;
    /**
     * 和OA关联的Code
     */
    private String linkingCode;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后操作时间
     */
    private Date ts;
    /**
     * 删除标记
     */
    private int archived;
}
