package com.poly.midware.mapper;

import com.poly.midware.modle.CountNumberModel;
import com.poly.midware.entity.OrganizationEntity;
import com.poly.midware.utils.driver.SimpleInsertLangDriver;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName  midware
 * @Package  com.poly.midware.mapper
 * @Author  longhai
 * @CreateDate  2018/5/3 18 19
 * @Version  1.0
 * pCopyright  Copyright (c) 2018/p
 */
@Mapper
public interface OrganizationMapper {

    @Insert("INSERT INTO organization(#{organization})")
    @Lang(SimpleInsertLangDriver.class)
    int insert(OrganizationEntity organization);

    @Select("SELECT * FROM organization WHERE archived='0';")
    List<OrganizationEntity> select();

    @Select("SELECT * FROM organization WHERE organizationSetid<>'@K' AND archived='0'  order by organizationUuid asc;")
    List<OrganizationEntity> selectUMUN();

    @Select("SELECT * FROM organization WHERE parentUuid= #{parent} AND archived='0' ;")
    List<OrganizationEntity> selectChilList(String parent);

    @Select("SELECT * FROM organization WHERE organizationUuid= #{organizationUuid}")
    List<OrganizationEntity> queryByOrganizationUuid(String organizationUuid);

    @Select("SELECT * FROM organization WHERE organizationUuid= #{organizationUuid}")
    OrganizationEntity queryOrganizationByUuid(String organizationUuid);

    @Update("UPDATE organization SET " +
            "organizationSetid = #{organizationSetid}," +
            "organizationUuid = #{organizationUuid}," +
            "organization = #{organization}," +
            "parentUuid = #{parentUuid}," +
            "linkingCode = #{linkingCode}," +
            "createTime = #{createTime}," +
            "ts = #{ts} " +
            "WHERE uniqueId = #{uniqueId};")
    int updateByOrganizationUuid(@Param("organizationSetid")String organizationSetid, @Param("organizationUuid")String organizationUuid, @Param("organization")String organization,
                                 @Param("parentUuid") String parentUuid, @Param("linkingCode")String linkingCode,@Param("createTime") Date createTime,
                                 @Param("ts")Date ts, @Param("uniqueId")String uniqueId);

    @Update("UPDATE organization SET archived='1' WHERE id > 0 AND uniqueId = #{uniqueId};")
    int deleteByOrganizationUuid(String uniqueId);

    @Delete("DELETE FROM organization WHERE id > 0 AND archived='4';")
    int deleteAllOrganization();

    @Update("UPDATE organization SET archived='4' WHERE id > 0;")
    int archiveAllOrganization();

    @Select("SELECT count(uniqueId) as number FROM organization where uniqueId = #{uniqueId};")
    CountNumberModel check(String uniqueId);

    @Select("SELECT * FROM organization_view WHERE ts=(SELECT MAX(ts) FROM organization_view) order by archived asc;")
    List<OrganizationEntity> ssoOrganizationPushPartial();


    @Insert("INSERT INTO organization_view(#{organization})")
    @Lang(SimpleInsertLangDriver.class)
    void insertOrganizationView(OrganizationEntity o);

}
