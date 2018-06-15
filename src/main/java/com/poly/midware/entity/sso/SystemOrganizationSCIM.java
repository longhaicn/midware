package com.poly.midware.entity.sso;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class SystemOrganizationSCIM implements Serializable {
    /**组织机构名称*/
    private String organization;
    /**
     * IDP PUSH TO SP USE
     * 组织机构ID
     */
    private String organizationUuid;
    /**父级*/
    private String parentUuid;

    /**
     * 直属子级OU
     */
    private List<String> childrenOuUuid = new ArrayList<>();

    /**
     * SCIM同步扩展字段类,以后只要是同步需要扩展字段的,都放在这个类里面.
     */
    private SCIMExtendField extendField;
}
