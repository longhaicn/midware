package com.poly.midware.mapper;

import com.poly.midware.modle.InfluenceDateModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.mapper
 * @Author: longhai
 * @CreateDate: 2018/5/28 17:06
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Mapper
public interface ConnectionTestMapper {

    @Select("SELECT max(ts) as influenced FROM stuff_view;")
    InfluenceDateModel influnencedStfDate();

    @Select("SELECT max(ts) as influenced FROM organization_view;")
    InfluenceDateModel influnencedOrgDate();
}
