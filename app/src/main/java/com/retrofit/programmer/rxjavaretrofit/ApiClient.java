package com.retrofit.programmer.rxjavaretrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sachin on 25/8/17.
 */

public class ApiClient {

    public static final String BASE_URL="https://reqres.in";
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient()
    {
        if (retrofit==null)
        {
            /*retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();*/

            //For Rxjava
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
