package com.poly.midware.mapper;

import com.poly.midware.entity.AuthAppEntity;
import com.poly.midware.utils.driver.SimpleInsertLangDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthAppMapper {

    @Insert("INSERT INTO authapp(#{authapp})")
    @Lang(SimpleInsertLangDriver.class)
    void insertAuth(AuthAppEntity authapp);

    @Update("UPDATE authapp SET " +
            "appname = #{appname}," +
            "appcode = #{appcode}," +
            "appuuid = #{appuuid}," +
            "WHERE appcode = #{appcode};")
    void updateAuth(@Param("id") String id,
                    @Param("appname") String appname,
                    @Param("appcode") String appcode,
                    @Param("appuuid") String appuuid );

    @Delete("DELETE FROM authapp WHERE appcode = #{appcode}")
    void deleteAuth(String appcode);

    AuthAppEntity selectAuth();

    List<AuthAppEntity> selectAuthList();
}
