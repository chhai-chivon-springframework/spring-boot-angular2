package com.chhaichivon.backend.springbootangular2.utils;

import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/7/2017
 * TIME   : 9:15 AM
 */
public interface BaseService<T> extends Serializable {
    public Object findAll();
    public T findById(long id);
    public T save(T entity);
    public void update(T entity);
    public void delete(T entity);
}
