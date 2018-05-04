package com.poly.midware.mapper;


import com.poly.midware.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 类别MyBatis的Mapper接口
 * @ProjectName: midware
 * @Package: com.poly.midware.mapper
 * @Author: longhai
 * @CreateDate: 2018/5/3
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Mapper
public interface CategoryMapper {

    @Results({
            @Result(property = "createAt", column = "create_at")
    })
    @Select("SELECT * FROM category WHERE id = #{id}")
    Category findById(@Param("id") long id);

    @Insert("INSERT INTO category(name, create_at) VALUES(#{name}, #{createAt})")
    int insert(Category category);

    @Results({
            @Result(property = "createAt", column = "create_at")
    })
    @Select("SELECT * FROM category ORDER BY id DESC")
    List<Category> findAll();

    @Update("UPDATE category SET nmae = #{name} WHERE id = #{id}")
    void update(Category category);

    @Delete("DELETE FROM category WHERE id = #{id}")
    void delete(long id);
}
