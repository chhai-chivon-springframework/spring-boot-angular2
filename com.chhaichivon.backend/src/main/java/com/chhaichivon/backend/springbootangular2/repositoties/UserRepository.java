package com.chhaichivon.backend.springbootangular2.repositoties;

import com.chhaichivon.backend.springbootangular2.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/5/2017
 * TIME   : 7:39 PM
 */

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	public User findByEmail(String email);
}
