
package com.assessment.heady_assessment.data_model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("child_categories")
    @Expose
    private List<Object> childCategories = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Category() {
    }

    /**
     * 
     * @param childCategories
     * @param id
     * @param name
     * @param products
     */
    public Category(Integer id, String name, List<Product> products, List<Object> childCategories) {
        super();
        this.id = id;
        this.name = name;
        this.products = products;
        this.childCategories = childCategories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Object> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Object> childCategories) {
        this.childCategories = childCategories;
    }

}
