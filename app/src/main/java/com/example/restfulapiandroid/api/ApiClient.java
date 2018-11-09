package com.example.restfulapiandroid.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ixi.Dv on 09/11/2018.
 * Email : feedback.mrzero@gmail.com
 */
public class ApiClient {
    public static final String API_BAS_URL = "http://10.0.3.2"; // change localhost to ip address

    private static Retrofit.Builder getRetrofitInstance() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_BAS_URL);
    }


    public static ApiService getService() {
        return getRetrofitInstance().build().create(ApiService.class);
    }
}
