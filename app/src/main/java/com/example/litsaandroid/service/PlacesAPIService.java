package com.example.litsaandroid.service;

import com.example.litsaandroid.model.Places;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlacesAPIService {
    @GET("place")
    Call<List<Places>> getAllPlaces(@Body List<String> keywords, @Body String address, @Body double radius);

    @GET("place/{id}")
    Call<Places> getPlaceById(@Path("id") int id);

}
