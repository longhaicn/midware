package com.poly.midware.mapper;

import com.poly.midware.entity.OrganizationEntity;
import com.poly.midware.entity.StuffEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.mapper
 * @Author: longhai
 * @CreateDate: 2018/6/22 9:20
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Mapper
public interface SyncMapper {

    @Select("SELECT * FROM organization_view WHERE archived<'3' ORDER BY  organizationSetid DESC;")
    List<OrganizationEntity> pOrganizationList();

    @Select("SELECT * FROM stuff_view WHERE archived<'10' ORDER BY archived ASC")
    List<StuffEntity> stuffList();

    @Select("SELECT * FROM organization_view WHERE archived='3' ORDER BY organizationSetid ASC;")
    List<OrganizationEntity> vOrganizationList();

    @Update("UPDATE stuff_view SET archived=#{archived} WHERE id > 0 AND userName=#{userName};")
    void successStf(@Param("userName")String userName, @Param("archived")int archived);

    @Update("UPDATE organization_view SET archived=#{archived} WHERE id > 0 AND organizationKey=#{organizationKey};")
    void successOrg(@Param("organizationKey")String organizationKey, @Param("archived")int archived);
}
