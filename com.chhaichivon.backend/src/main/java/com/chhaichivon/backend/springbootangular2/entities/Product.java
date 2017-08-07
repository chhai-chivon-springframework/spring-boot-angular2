package com.chhaichivon.backend.springbootangular2.entities;

import com.chhaichivon.backend.springbootangular2.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/5/2017
 * TIME   : 7:41 PM
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_product")
public class Product extends BaseEntity{
    @Column(name = "product_name")
    private String ProductName;
    @Column(name = "price")
    private String price;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "description")
    private String description;

}
