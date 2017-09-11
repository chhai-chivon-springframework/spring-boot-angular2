package com.chhaichivon.backend.springbootangular2.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @JsonProperty("NAME")
    private String name;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="parent")
    @JsonProperty("PARENT")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private List<Category> childCategories = new ArrayList<>();

    @Column(name = "description")
    @JsonProperty("DESCRIPTION")
    private String description;
}
