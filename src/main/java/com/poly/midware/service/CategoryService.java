package com.poly.midware.service;

import com.poly.midware.entity.Category;
import com.poly.midware.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 类别Service类
 * @ProjectName: midware
 * @Package: com.poly.midware.service
 * @Author: longhai
 * @CreateDate: 2018/5/3
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    public Category findById(long id) {
        return categoryMapper.findById(id);
    }

    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    public int create(String name) {
        Category category = new Category();
        category.setName(name);
        category.setCreateAt(new Date());
        return categoryMapper.insert(category);
    }

    public void update(Category category) {
        categoryMapper.update(category);
    }

    public void delete(long id) {
        categoryMapper.delete(id);
    }

}
