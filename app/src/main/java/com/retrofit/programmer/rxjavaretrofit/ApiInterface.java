package com.retrofit.programmer.rxjavaretrofit;

import rx.Observable;
import model.Data;
import model.Model;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sachin on 25/8/17.
 */

public interface ApiInterface {

   @GET("/api/users/2")
    //without RxJAVA
    // Call<Model> getData();

   //for RxJAVA
   Observable<Model> getData();

}
