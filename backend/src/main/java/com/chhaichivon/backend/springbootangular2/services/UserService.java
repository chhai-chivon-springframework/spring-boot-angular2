package com.chhaichivon.backend.springbootangular2.services;

import com.chhaichivon.backend.springbootangular2.models.User;
import com.chhaichivon.backend.springbootangular2.repositoties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/5/2017
 * TIME   : 7:38 PM
 */
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Object findAll(){
		return userRepository.findAll();
	}

	public User findById(Long id){
		return userRepository.findOne(id);
	}

	public User save(User user){
		return userRepository.save(user);
	}

	public void delete(User user){
		userRepository.delete(user);
		return;
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
