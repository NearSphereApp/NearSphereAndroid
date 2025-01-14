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
    private ArrayList<Places> places = new ArrayList<>();
    private MutableLiveData<List<Places>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    HomeFragment home;

    public PlacesRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Places>> getMutableLiveData(){
        //TO-DO add Logic when have Retrofit instance
        PlacesAPIService placesApiService = RetrofitInstance.getService();
        Call<List<Places>> call = placesApiService.getAllPlaces(home.keyWord, home.address, home.radius);
        call.enqueue(
                new Callback<>() {
                    public void onResponse(@NonNull Call<List<Places>> call, @NonNull Response<List<Places>> response) {
                        List<Places> album = response.body();
                        mutableLiveData.setValue(album);
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Places>> call, @NonNull Throwable t) {
                        Log.i("GET request", Objects.requireNonNull(t.getMessage()));
                    }
                }
        );
        return mutableLiveData;
    }
}
