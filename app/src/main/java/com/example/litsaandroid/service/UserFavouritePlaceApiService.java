package com.example.litsaandroid.service;

import com.example.litsaandroid.model.UserFavouritePlace;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserFavouritePlaceApiService {

    @GET("favourites")
    Call<List<UserFavouritePlace>> getAllFavourites();

    @POST("favourites")
    Call<UserFavouritePlace> addUserFavouritePlace(@Body UserFavouritePlace userFavouritePlace);

    @DELETE("favourites/{id}")
    Call<String> deleteUserFavouritePlace(@Path("id") long id);
}
