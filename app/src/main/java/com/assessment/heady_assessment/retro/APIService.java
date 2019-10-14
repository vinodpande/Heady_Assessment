package com.assessment.heady_assessment.retro;

import com.assessment.heady_assessment.data_model.CategoriesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {

    @GET("json")
Observable<CategoriesResponse> getCategoriesResponseObservable();
}
