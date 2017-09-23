package com.chhaichivon.backend.springbootangular2.controllers;

import com.chhaichivon.backend.springbootangular2.models.User;
import com.chhaichivon.backend.springbootangular2.services.UserService;
import com.chhaichivon.backend.springbootangular2.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/5/2017
 * TIME   : 7:38 PM
 */

@RestController
@RequestMapping(value = "/api")
public class UserController extends BaseController<User>{

	@Autowired
	private UserService  userService;
	public Map<String, Object> map;

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Map<String, Object>> getAllProduct(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "15") int limit
	) {
		Page<User> products = null;
		try {
			products = userService.findAll(new PageRequest(page,limit));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseJson(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
		map = new HashMap<>();
		User user = null;
		try {
			user = userService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseJson(user,HttpStatus.OK);
	}


	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public ResponseEntity<Map<String, Object>> save(@RequestBody User user) {
		map = new HashMap<>();
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseJson(user,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") long id) {
		map = new HashMap<>();
		User user = userService.findById(id);
		try {
			if (user != null) {
				userService.delete(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseJson(user, HttpStatus.OK);
	}
}
