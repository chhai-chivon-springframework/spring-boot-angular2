package com.chhaichivon.backend.springbootangular2.controllers;

import com.chhaichivon.backend.springbootangular2.models.Product;
import com.chhaichivon.backend.springbootangular2.services.ProductService;
import com.chhaichivon.backend.springbootangular2.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
 * TIME   : 3:47 PM
 */

@RestController
@RequestMapping(value = "/api")
public class ProductController extends BaseController<Product> {
    @Autowired
    private ProductService productService;
    public Map<String, Object> map;

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "15") int limit
    ){
        Page<Product> products= null;
        try {
            products =  productService.findAll(new PageRequest(page,limit));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error" + e.getMessage());
        }
        return responseJson(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        Product product = null;
        try {
            product = productService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product,HttpStatus.OK);
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST, headers = "Accept=Application/json")
    public ResponseEntity<Map<String, Object>> save(@RequestBody Product product) {
        map = new HashMap<>();
        try {
            productService.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT, headers = "Accept=Application/json")
    public ResponseEntity<Map<String, Object>> update(@PathVariable("id") Long id, @RequestBody Product newProduct){
        map = new HashMap<>();
        Product oldProduct = null;
        try {
            oldProduct  = productService.findById(id);
            if(oldProduct !=  null){
                oldProduct.setProductName(newProduct.getProductName());
                oldProduct.setPrice(newProduct.getPrice());
                oldProduct.setImageUrl(newProduct.getImageUrl());
                oldProduct.setDescription(newProduct.getDescription());
                productService.update(oldProduct);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return responseJson(oldProduct,HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") long id) {
        map = new HashMap<>();
        Product product = productService.findById(id);
        try {
            if (product != null) {
                productService.delete(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product, HttpStatus.OK);
    }
}
