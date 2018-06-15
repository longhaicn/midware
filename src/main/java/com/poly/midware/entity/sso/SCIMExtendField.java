package com.poly.midware.entity.sso;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * SCIM同步扩展字段类
 * Created by Shaofei Du on 2017/10/20.
 */
@Data
public class SCIMExtendField implements Serializable {
    private static final long serialVersionUID = -1640081131451778606L;

    private Map<String,Object> attributes = new HashMap<>();


}
