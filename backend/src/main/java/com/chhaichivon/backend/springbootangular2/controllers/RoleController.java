package com.chhaichivon.backend.springbootangular2.controllers;

import com.chhaichivon.backend.springbootangular2.models.Role;
import com.chhaichivon.backend.springbootangular2.services.RoleService;
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
import java.util.List;
import java.util.Map;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/7/2017
 * TIME   : 9:21 AM
 */

@RestController
@RequestMapping(value = "/api")
public class RoleController extends BaseController<Role>{
    @Autowired
    private RoleService roleService;
    public Map<String, Object> map;
    
    @RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false,defaultValue = "10") int limit
    ){
        Page<Role> roles= null;
        try {
            roles = roleService.findAll(new PageRequest(page,limit));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error" + e.getMessage());
        }
        return responseJson(roles, HttpStatus.OK);
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        Role role = null;
        try {
            role = roleService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(role,HttpStatus.OK);
    }


    @RequestMapping(value = "/roles", method = RequestMethod.POST, headers = "Accept=Application/json")
    public ResponseEntity<Map<String, Object>> save(@RequestBody Role role) {
        map = new HashMap<>();
        try {
            roleService.save(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(role,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT, headers = "Accept=Application/json")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Role roleUpdate){
        map = new HashMap<>();
        try {
            if(roleUpdate !=  null){
                roleService.update(roleUpdate);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return responseJson(roleUpdate,HttpStatus.OK);
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") long id) {
        map = new HashMap<>();
        Role role = roleService.findById(id);
        try {
            if (role != null) {
                roleService.delete(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(role, HttpStatus.OK);
    }
}
