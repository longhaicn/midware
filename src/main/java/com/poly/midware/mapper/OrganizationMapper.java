package com.poly.midware.mapper;

import com.poly.midware.entity.OrganizationEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.mapper
 * @Author: longhai
 * @CreateDate: 2018/5/3 18:19
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Mapper
public interface OrganizationMapper {
    @Insert("INSERT INTO organization( ) VALUES( )")
    int insert(OrganizationEntity organization);
}
