package com.poly.midware.entity.sso;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by longhai on 2018/6/26.
 */
@Data
public class Belongs implements Serializable {
    /**
     *
     */
    private String ouDirectory;

    private String belongOuUuid;

    private boolean rootNode;

    private String ddtalkDepartId;

    public Belongs() {
    }


}
