package com.chhaichivon.backend.springbootangular2.services;

import com.chhaichivon.backend.springbootangular2.models.Category;
import com.chhaichivon.backend.springbootangular2.repositoties.CategoryRepository;
import com.chhaichivon.backend.springbootangular2.utils.BaseService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/7/2017
 * TIME   : 3:46 PM
 */
@Service
public class CategoryService implements BaseService<Category> {
    @Autowired
    private CategoryRepository  categoryRepository;

    @Override
    public Category findById(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public void update(Category entity) {
        categoryRepository.save(entity);
    }

    @Override
    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }

}
