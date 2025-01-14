package com.example.litsaandroid;

import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.litsaandroid.databinding.PlaceClickBinding;
import com.example.litsaandroid.model.Places;
import com.example.litsaandroid.ui.mainActivity.MainActivityViewModel;

public class PlaceClickActivity extends AppCompatActivity {

        private PlaceClickBinding placeClickBinding;
        private Places places;
        private static final String PLACES_KEY = "places";

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.place_click);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                places = getIntent().getParcelableExtra(PLACES_KEY, Places.class);
            }
            placeClickBinding = DataBindingUtil.setContentView(
                    this,
                    R.layout.place_click
            );

            MainActivityViewModel mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

            placeClickBinding.setPlaces(places);
        }
    }

