package com.assessment.heady_assessment.retro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClass {
    static final String BASE_URL="https://stark-spire-93433.herokuapp.com/";

    public static Retrofit getRetrofitInstance(){
        Retrofit getRetrofitInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return getRetrofitInstance;
    }

    public static APIService getApiService(){
        APIService apiService=getRetrofitInstance().create(APIService.class);
        return apiService;
    }
}
