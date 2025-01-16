package com.example.litsaandroid.model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.litsaandroid.HomeFragment;
import com.example.litsaandroid.service.PlacesAPIService;
import com.example.litsaandroid.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlacesRepository {
    private MutableLiveData<List<Places>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    HomeFragment home;
    public PlacesRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Places>> getMutableLiveData(Places places){
        PlacesAPIService placesApiService = RetrofitInstance.getService();
//       Call<List<Places>> call = placesApiService.getAllPlaces(placeModel.getLatitude(), placeModel.getLongitude(), placeModel.getRadius(), placeModel.getKeyWord());
        Call<List<Places>> call = placesApiService.getAllPlaces(places.getLatitude(), places.getLongitude(), places.getRadius(), places.getKeyWord());

        call.enqueue(
                new Callback<List<Places>>() {
                    public void onResponse( Call<List<Places>> call, Response<List<Places>> response) {
                        List<Places> responseBody = response.body();
                        mutableLiveData.setValue(responseBody);
                    }

                    @Override
                    public void onFailure( Call<List<Places>> call, Throwable t) {
                        Log.i("GET request", Objects.requireNonNull(t.getMessage()));
                    }
                }
        );
        return mutableLiveData;
    }
}
