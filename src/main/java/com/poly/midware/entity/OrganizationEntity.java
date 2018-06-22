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
     * 机构类型：单位:UN  部门:UM   岗位:@K
     */
    private String organizationSetid;
    /**
     * 组织机构的ID
     */
    private String organizationUuid;
    /**
     * 组织机构的Key
     */
    private String organizationKey;
    /**
     * 组织机构名称
     */
    private String organization;
    /**
     * 所属父级组织机构的ID
     */
    private String parentUuid;
    /**
     * 所属父级组织机构的Key
     */
    private String parentKey;
    /**
     * OU的所有直属子级
     */
    private String childrenOuUuid;
    /**
     * OU的所有直属子级Key
     */
    private String childrenKey;
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
     * 归档标记   默认0标识有效 1标识归档  4标识全量暂时标记 10标识暂时标记存在
     */
    private int archived;
}
