package com.poly.midware.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.entity
 * @Author: longhai
 * @CreateDate: 2018/6/6 14:47
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
public class OrganizationTreeEntity {
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
        private List<OrganizationTreeEntity> childrenOuUuidList;
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
