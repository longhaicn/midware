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
public class EmailSCIM implements Serializable{
    private static final long serialVersionUID = -7406707216090876374L;

    private String value;

    private String type;

    private String primary;


    public EmailSCIM(){

    }


}
