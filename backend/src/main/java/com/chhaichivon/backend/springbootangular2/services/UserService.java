package com.chhaichivon.backend.springbootangular2.services;

import com.chhaichivon.backend.springbootangular2.models.User;
import com.chhaichivon.backend.springbootangular2.repositoties.UserRepository;
import com.chhaichivon.backend.springbootangular2.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/5/2017
 * TIME   : 7:38 PM
 */
@Service
public class UserService implements BaseService<User> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public User findById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public void update(User entity) {
		userRepository.save(entity);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}
}
