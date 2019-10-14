
package com.assessment.heady_assessment.data_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Product_() {
    }

    /**
     * 
     * @param id
     * @param viewCount
     */
    public Product_(Integer id, Integer viewCount) {
        super();
        this.id = id;
        this.viewCount = viewCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

}
