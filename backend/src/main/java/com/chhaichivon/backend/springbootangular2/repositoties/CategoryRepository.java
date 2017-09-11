package com.chhaichivon.backend.springbootangular2.repositoties;

import com.chhaichivon.backend.springbootangular2.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/7/2017
 * TIME   : 3:44 PM
 */
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
