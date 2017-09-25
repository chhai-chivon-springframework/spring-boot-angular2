package com.chhaichivon.backend.springbootangular2.models;

import com.chhaichivon.backend.springbootangular2.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column
    private String productName;

    @Column
    private String price;

    @Column
    private String imageUrl;

    @Column
    private String description;

}
