package com.chhaichivon.backend.springbootangular2.repositoties;

import com.chhaichivon.backend.springbootangular2.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/7/2017
 * TIME   : 3:43 PM
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
}
