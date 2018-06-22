package com.poly.midware.mapper;

import com.poly.midware.modle.CountNumberModel;
import com.poly.midware.entity.StuffEntity;
import com.poly.midware.utils.driver.SimpleInsertLangDriver;
import com.poly.midware.utils.driver.SimpleUpdateLangDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.mapper
 * @Author: longhai
 * @CreateDate: 2018/5/3 18:19
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Mapper
public interface StuffMapper {

    @Insert("INSERT INTO stuff(#{stuffEntity})")
    @Lang(SimpleInsertLangDriver.class)
    int insert(StuffEntity stuffEntity);

    @Select("SELECT * FROM stuff")
    List<StuffEntity> select();

    @Select("SELECT * FROM stuff WHERE userName = #{userName}")
    List<StuffEntity> queryByUserName(String userName);

    @Update("UPDATE stuff (#{stuff}) WHERE userName = #{userName}")
    @Lang(SimpleUpdateLangDriver.class)
    int updateByUserName(StuffEntity stuff);

    @Delete("DELETE FROM stuff WHERE userName=#{userName}")
    int deleteByUserName(String userName);

    @Delete("DELETE FROM stuff WHERE id > 0 AND archived='4';")
    int deleteAllStuff();

    @Update("UPDATE stuff SET archived='4' WHERE id > 0;")
    int archiveAllStuff();

    @Select("SELECT count(uniqueId) as number FROM stuff where userName = #{userName};")
    CountNumberModel checkUser(String userName);

    @Update("UPDATE stuff SET archived='1' WHERE id > 0 AND userName = #{userName};")
    void archiveStuff(String uniqueId);

    @Update("UPDATE stuff (#{stuff}) WHERE uniqueId = #{userName}")
    @Lang(SimpleUpdateLangDriver.class)
    void updateStuff(StuffEntity stuff);

    @Insert("INSERT INTO stuff_view(#{stuffEntity})")
    @Lang(SimpleInsertLangDriver.class)
    void ssoStuffInsert(StuffEntity e);


    @Select("SELECT * FROM stuff WHERE archived='0';")
    List<StuffEntity> ssoStuffPushAll();

    @Select("SELECT * FROM stuff_view WHERE archived<'10';")
    List<StuffEntity> ssoStuffPushPartial();

    @Update("UPDATE stuff_view SET archived=#{archived} WHERE id > 0 AND userName=#{userName};")
    void success( @Param("userName")String userName,  @Param("archived")int archived);

    @Insert("INSERT INTO stuff_view(#{stuffEntity})")
    @Lang(SimpleInsertLangDriver.class)
    int insertView(StuffEntity stuffEntity);

    @Update("UPDATE stuff SET archived='1' WHERE id > 0 AND userName=#{userName};")
    void archiveByUserName(String userName);
}
