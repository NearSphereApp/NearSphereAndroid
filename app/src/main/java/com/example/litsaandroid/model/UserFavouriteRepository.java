package com.example.litsaandroid.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.litsaandroid.service.UserFavouritePlaceApiService;

import java.util.List;

public class UserFavouriteRepository {
    private UserFavouritePlaceApiService userFavouritePlaceApiService;

    private MutableLiveData<List<UserFavouritePlace>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public UserFavouriteRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<UserFavouritePlace>> getMutableLiveData(){
        //TO-DO - add logic with retrofit instance
        return mutableLiveData;
    }

    public void addFavourite(){
        //TO-DO - add logic
    }

    public void deleteFavourite(){
        //TO-DO - add logic
    }
}
