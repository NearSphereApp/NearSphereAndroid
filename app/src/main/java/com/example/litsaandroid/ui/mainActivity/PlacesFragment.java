package com.example.litsaandroid.ui.mainActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.litsaandroid.R;
import com.example.litsaandroid.databinding.FragmentPlacesBinding;
import com.example.litsaandroid.model.Places;
import com.example.litsaandroid.model.SearchParameters;
import com.example.litsaandroid.ui.mainActivity.Adapter;
import com.example.litsaandroid.ui.mainActivity.MainActivityViewModel;
import com.example.litsaandroid.ui.mainActivity.RecyclerViewInterface;
import com.example.litsaandroid.ui.placeclick.PlaceClickActivity;
import java.util.ArrayList;
import java.util.List;

public class PlacesFragment extends Fragment implements RecyclerViewInterface {

    private ArrayList<Places> placesList;
    private Adapter adapter;
    private FragmentPlacesBinding binding;
    private MainActivityViewModel mainActivityViewModel;
    private double homeLatitude;
    private double homeLongitude;
    private double homeRadius;
    private List<String> homeKeywords;

    private static final String PLACES_KEY = "places";

    public PlacesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            SearchParameters params = getArguments().getParcelable("search_parameters");
            if (params != null) {
                homeLatitude = params.getLatitude();
                homeLongitude = params.getLongitude();
                homeRadius = params.getRadius();
                homeKeywords = params.getKeywords();
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_places, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        setupRecyclerView();
        getAllPlaces();
    }

    private void setupRecyclerView() {
        adapter = new Adapter(new ArrayList<>(), this);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerview.setAdapter(adapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getAllPlaces() {
        mainActivityViewModel.getPlaces(homeLatitude, homeLongitude, homeRadius, homeKeywords)
                .observe(getViewLifecycleOwner(), places -> {
                    if (places != null) {
                        placesList = new ArrayList<>(places);
                        adapter.setPlacesList(placesList);
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.e("PlacesFragment", "No places were returned.");
                    }
                });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext(), PlaceClickActivity.class);
        intent.putExtra(PLACES_KEY, placesList.get(position));
        startActivity(intent);
    }
}