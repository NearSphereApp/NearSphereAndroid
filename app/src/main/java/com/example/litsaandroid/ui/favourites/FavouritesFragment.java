package com.example.litsaandroid.ui.favourites;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.litsaandroid.R;
import com.example.litsaandroid.databinding.FragmentPlacesBinding;
import com.example.litsaandroid.model.Favourites;
import com.example.litsaandroid.ui.mainActivity.Adapter;
import com.example.litsaandroid.ui.mainActivity.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.List;

public class FavouritesFragment extends Fragment implements RecyclerViewInterface {

    private static final String PLACES_KEY = "places";
    private RecyclerView recyclerView;
    private ArrayList<Favourites> favouritesList;

    private Favourites userFavouritePlace;
    private Adapter adapter;
    private FragmentPlacesBinding binding;
    private FavouritesViewModel favouritesViewModel;
    private FavouritesClickHandler clickHandler;

    public FavouritesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourites, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        favouritesViewModel = new ViewModelProvider(this).get(FavouritesViewModel.class);
        clickHandler = new FavouritesClickHandler(this.getContext(), userFavouritePlace, favouritesViewModel );
        getFavouritePlaces();
    }

    private void getFavouritePlaces(){
        favouritesViewModel.getAllFavourites().observe(getViewLifecycleOwner(), new Observer<List<Favourites>>() {
            @Override
            public void onChanged(List<Favourites> favourites) {
                favouritesList = (ArrayList<Favourites>) favourites;
            }
            //Need some logic to check if added to favourites here
        });
    }


    @Override
    public void onItemClick(int position) {

    }
}