package com.example.litsaandroid.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class PlacesRepository {
    private ArrayList<Places> places = new ArrayList<>();
    private MutableLiveData<List<Places>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public PlacesRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Places>> getMutableLiveData(){
        //TO-DO add Logic when have Retrofit instance
        return mutableLiveData;
    }
}
