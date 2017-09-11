package com.chhaichivon.backend.springbootangular2.utils;

import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/5/2017
 * TIME   : 8:03 PM
 */
public interface BaseRepository<T> {
	public T findById(long id);
	public Boolean save(T entity);
	public Boolean update(T entity);
	public Boolean delete(long id);
	public List<T> findAll(Pagination entityPage);
}
