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

    @Select("SELECT * FROM organization WHERE organizationKey= #{organizationKey}")
    List<OrganizationEntity> queryByOrganizationKey(String organizationKey);

    @Select("SELECT * FROM organization WHERE organizationKey= #{organizationKey}")
    OrganizationEntity queryOrganizationByKey(String organizationKey);

    @Update("UPDATE organization SET " +
            "organizationSetid = #{organizationSetid}," +
            "organizationUuid = #{organizationUuid}," +
            "organizationKey = #{organizationKey}," +
            "organization = #{organization}," +
            "parentUuid = #{parentUuid}," +
            "parentKey = #{parentKey}," +
            "childrenOuUuid = #{childrenOuUuid}," +
            "childrenKey = #{childrenKey}," +
            "linkingCode = #{linkingCode}," +
            "ts = #{ts} " +
            "WHERE organizationKey = #{organizationKey};")
    int updateByOuKey(
            @Param("organizationSetid") String organizationSetid,
            @Param("organizationUuid") String organizationUuid,
            @Param("organizationKey") String organizationKey,
            @Param("organization") String organization,
            @Param("parentUuid") String parentUuid,
            @Param("parentKey") String parentKey,
            @Param("childrenOuUuid") String childrenOuUuid,
            @Param("childrenKey") String childrenKey,
            @Param("linkingCode") String linkingCode,
            @Param("ts") Date ts);

    @Update("UPDATE organization SET archived='1' WHERE id > 0 AND organizationKey = #{organizationKey};")
    int deleteByOrganizationKey(String organizationKey);

    @Delete("DELETE FROM organization WHERE id > 0 AND archived='4';")
    int deleteAllOrganization();

    @Update("UPDATE organization SET archived='4' WHERE id > 0;")
    int archiveAllOrganization();

    @Insert("INSERT INTO organization_view(#{organization})")
    @Lang(SimpleInsertLangDriver.class)
    void insertView(OrganizationEntity o);

    @Select("SELECT count(organizationKey) as number FROM organization where organizationKey = #{organizationKey} AND archived='0';")
    @Results({
            @Result(column="number", property="number"),
    })
    CountNumberModel checkOuKey(@Param("organizationKey") String organizationKey);

    @Select("SELECT * FROM organization_view WHERE archived < '14' ORDER BY id DESC;")
    List<OrganizationEntity> ssoOrganizationPushPartial();

    @Update("UPDATE organization_view SET archived=#{archived} WHERE id > 0 AND organizationKey=#{organizationKey};")
    void success(@Param("organizationKey") String organizationKey, @Param("archived") int archived);

    @Update("UPDATE organization SET archived='1' WHERE id>0 AND organizationKey = #{organizationKey};")
    void deleteByOuKey(String organizationKey);
}
