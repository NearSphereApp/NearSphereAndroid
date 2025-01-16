package com.example.litsaandroid.service;

import com.example.litsaandroid.model.Places;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlacesAPIService {
    @GET("place")
    Call<List<Places>> getAllPlaces(@Query("latitude") double lat, @Query("longitude") double lng, @Query("radius") double radius, @Query("keywords") List<String> keywords);

    @GET("place/{id}")
    Call<Places> getPlaceById(@Path("id") int id);

}
