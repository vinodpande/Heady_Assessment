package com.assessment.heady_assessment.repository;

import com.assessment.heady_assessment.data_model.CategoriesResponse;
import com.assessment.heady_assessment.retro.RetrofitClass;

import io.reactivex.Observable;


public class CategoriesRepo {
    static Observable<CategoriesResponse> categoriesResponseObservable;
    public static Observable<CategoriesResponse> getcategoriesResponse(){
        categoriesResponseObservable= RetrofitClass.getApiService().getCategoriesResponseObservable();
        return categoriesResponseObservable;
    }
}
