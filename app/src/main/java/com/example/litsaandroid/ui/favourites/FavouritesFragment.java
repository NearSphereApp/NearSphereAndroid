package com.example.litsaandroid.ui.favourites;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.litsaandroid.R;
import com.example.litsaandroid.databinding.FragmentPlacesBinding;
import com.example.litsaandroid.databinding.PlaceClickBinding;
import com.example.litsaandroid.model.Places;
import com.example.litsaandroid.ui.mainActivity.Adapter;
import com.example.litsaandroid.ui.mainActivity.MainActivityViewModel;
import com.example.litsaandroid.ui.mainActivity.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.List;

public class FavouritesFragment extends Fragment implements RecyclerViewInterface {

    private static final String PLACES_KEY = "places";
    private RecyclerView recyclerView;
    private ArrayList<Places> placesList;
    private Adapter adapter;
    private FragmentPlacesBinding binding;
    private MainActivityViewModel mainActivityViewModel;

    public FavouritesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourites, container, false);
        return binding.getRoot();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
//        super.onViewCreated(view, savedInstanceState);
//        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
//
//        getFavouritePlaces();
//    }

//    private void getFavouritePlaces(){
//        mainActivityViewModel.getAllPlaces().observe(getViewLifecycleOwner(), new Observer<List<Places>>() {
//            @Override
//            public void onChanged(List<Places> places) {
//                placesList = (ArrayList<Places>) places;
//
//            }
//            //Need some logic to check if added to favourites here
//        });
//    }


    @Override
    public void onItemClick(int position) {

    }
}