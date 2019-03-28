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

import lombok.Data;

import java.io.Serializable;

/**
 * Created by ZhiBo Feng.
 */
@Data
public class PhoneNumberSCIM implements Serializable{
    private static final long serialVersionUID = -5681553341913026275L;

    private String value;

    private String type;

    public PhoneNumberSCIM(){}


}
