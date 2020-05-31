package com.iamkosgei.androidjetpackpaging.api;


import com.iamkosgei.androidjetpackpaging.models.StudentsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("/")
    Call<StudentsResponse> getStudents(@Query("page") int page);
}

