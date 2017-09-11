package com.chhaichivon.backend.springbootangular2.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/11/2017
 * TIME   : 4:22 PM
 */

@Data
public class CategoryForm implements Serializable {
    @JsonProperty("CATEGORY_NAME")
    private String categoryName;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("PARENT_ID")
    private long mainCategoryId;

}
