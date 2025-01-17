package com.example.litsaandroid.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserFavouritePlaceApiService {

    @GET("favourites")
    Call<List<Favourites>> getAllFavourites();

    @POST("favourites")
    Call<Favourites> addFavourite(@Body Favourites favourites);

    @DELETE("favourites/{id}")
    Call<String> deleteFavourite(@Path("id") String id);
}
