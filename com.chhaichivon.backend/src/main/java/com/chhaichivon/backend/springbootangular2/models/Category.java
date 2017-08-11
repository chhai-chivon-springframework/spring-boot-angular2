package com.chhaichivon.backend.springbootangular2.models;

import com.chhaichivon.backend.springbootangular2.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/7/2017
 * TIME   : 3:43 PM
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_category")
public class Category implements Serializable{

    @Id
    @SequenceGenerator(allocationSize=1, initialValue=2, sequenceName="category_cat_id_seq", name="cat_id")
    @GeneratedValue(generator="cat_id", strategy=GenerationType.SEQUENCE)
    @Column(name="cat_id")
    @JsonProperty("ID")
    private  long id;

    @Column(name = "cat_name")
    @JsonProperty("CATEGORY_NAME")
    private String categoryName;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="main_cat_id")
    @JsonProperty("MAIN_CATEGORY")
    private Category mainCategory;

    @OneToMany(mappedBy="mainCategory")
    @JsonProperty("SUB_CATEGORY")
    private Set<Category> subCategory = new HashSet<>();

    @Column(name = "description")
    @JsonProperty("DESCRIPTION")
    private String description;

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }
}
