/*
 * Copyright (c) 2016 BeiJing JZYT Technology Co. Ltd
 * www.idsmanager.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * BeiJing JZYT Technology Co. Ltd ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with BeiJing JZYT Technology Co. Ltd.
 */
package com.poly.midware.entity.sso;

import java.io.Serializable;

/**
 * Created by ZhiBo Feng.
 */
public class PhoneNumberSCIM implements Serializable{
    private static final long serialVersionUID = -5681553341913026275L;

    private String value;

    private String type;

    public PhoneNumberSCIM(){}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
