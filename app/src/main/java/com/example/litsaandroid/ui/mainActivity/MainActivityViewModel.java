package com.example.litsaandroid.ui.mainActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.litsaandroid.model.Places;
import com.example.litsaandroid.repositories.PlacesRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private PlacesRepository placesRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.placesRepository = new PlacesRepository(application);
    }

    public LiveData<List<Places>> getPlaces(double latitude, double longitude, double radius, List<String> keywords){
        return placesRepository.getPlaces(latitude, longitude, radius, keywords);
    }
}
