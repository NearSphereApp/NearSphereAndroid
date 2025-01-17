package com.example.litsaandroid.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.litsaandroid.service.PlacesAPIService;
import com.example.litsaandroid.service.RetrofitInstance;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlacesRepository {
    private final MutableLiveData<List<Places>> mutableLiveData = new MutableLiveData<>();
    private PlacesAPIService placesApiService;
    private Application application;

    public PlacesRepository(Application application) {
        this.application = application;
        placesApiService = RetrofitInstance.getService().create(PlacesAPIService.class);
    }

    public MutableLiveData<List<Places>> getPlaces(double latitude, double longitude, double radius, List<String> keywords){

        Call<List<Places>> call = placesApiService.getAllPlaces(latitude, longitude, radius, keywords);

        call.enqueue(new Callback<List<Places>>() {
            @Override
            public void onResponse(Call<List<Places>> call, Response<List<Places>> response) {
                if(response.isSuccessful() && response.body() != null) {
                    Log.i("API Response", response.body().toString());
                    mutableLiveData.setValue(response.body());
                } else {
                    Log.e("API Response", "Response unsuccessful or empty");
                }
            }

            @Override
            public void onFailure(Call<List<Places>> call, Throwable t) {
                Log.e("API Error", Objects.requireNonNull(t.getMessage()));
            }
        });
        return mutableLiveData;
    }
}
