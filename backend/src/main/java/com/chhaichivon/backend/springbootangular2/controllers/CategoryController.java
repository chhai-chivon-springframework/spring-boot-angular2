package com.chhaichivon.backend.springbootangular2.controllers;

import com.chhaichivon.backend.springbootangular2.forms.CategoryForm;
import com.chhaichivon.backend.springbootangular2.models.Category;
import com.chhaichivon.backend.springbootangular2.services.CategoryService;
import com.chhaichivon.backend.springbootangular2.utils.BaseController;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Set;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/7/2017
 * TIME   : 3:47 PM
 */
@RestController
@RequestMapping(value = "/api")
public class CategoryController extends BaseController<Category> {
    @Autowired
    private CategoryService categoryService;
    public Map<String, Object> map;

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit
    ){
        Page<Category> categories= null;
        try {
            categories = categoryService.findAll(new PageRequest(page,limit));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error" + e.getMessage());
        }
        return responseJson(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        Category  category = null;
        try {
            category = categoryService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(category,HttpStatus.OK);
    }


    @RequestMapping(value = "/categories", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody Category category) {
        map = new HashMap<>();
       try{
           if(category != null){
               categoryService.save(category);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return responseJson(category,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> update(@Valid Category category){
        map = new HashMap<>();
        try {
            if(category !=  null){
                categoryService.update(category);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseJson(category,HttpStatus.OK);
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") long id) {
        map = new HashMap<>();
        Category category = categoryService.findById(id);
        try {
            if (category != null) {
                categoryService.delete(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(category, HttpStatus.OK);
    }
}
