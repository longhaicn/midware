package com.poly.midware.mapper;

import com.poly.midware.entity.auth.AppInfoEntity;
import com.poly.midware.utils.driver.SimpleInsertLangDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthAppMapper {

    @Insert("INSERT INTO authapp(#{authapp})")
    @Lang(SimpleInsertLangDriver.class)
    void insertAuth(AppInfoEntity authapp);

    @Update("UPDATE authapp SET " +
            "appname = #{appname}," +
            "appcode = #{appcode}," +
            "appuuid = #{appuuid}," +
            "WHERE appcode = #{appcode};")
    void updateAuth(@Param("id") int id,
                    @Param("appname") String appname,
                    @Param("appcode") String appcode,
                    @Param("appuuid") String appuuid);

    @Delete("DELETE FROM authapp WHERE appcode = #{appcode}")
    void deleteAuth(String appcode);


    @Select("SELECT * FROM authapp WHERE appcode= #{appcode}")
    AppInfoEntity selectAuth(String appcode);

    @Select("SELECT * FROM authapp;")
    List<AppInfoEntity> selectAuthList();
}
