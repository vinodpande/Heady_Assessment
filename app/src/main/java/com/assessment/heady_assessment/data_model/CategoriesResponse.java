
package com.assessment.heady_assessment.data_model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesResponse {

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("rankings")
    @Expose
    private List<Ranking> rankings = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CategoriesResponse() {
    }

    /**
     * 
     * @param rankings
     * @param categories
     */
    public CategoriesResponse(List<Category> categories, List<Ranking> rankings) {
        super();
        this.categories = categories;
        this.rankings = rankings;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

}
