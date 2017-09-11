package com.chhaichivon.backend.springbootangular2.repositoties;

import com.chhaichivon.backend.springbootangular2.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/7/2017
 * TIME   : 9:13 AM
 */

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role,Long> {
}
