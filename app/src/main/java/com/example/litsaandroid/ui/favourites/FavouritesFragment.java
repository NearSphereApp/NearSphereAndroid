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
import com.example.litsaandroid.databinding.FragmentFavouritesBinding;
import com.example.litsaandroid.databinding.FragmentPlacesBinding;
import com.example.litsaandroid.model.Favourites;
import com.example.litsaandroid.model.SearchParameters;
import com.example.litsaandroid.model.User;
import com.example.litsaandroid.ui.mainActivity.Adapter;
import com.example.litsaandroid.ui.mainActivity.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.List;

public class FavouritesFragment extends Fragment implements RecyclerViewInterface {

    private ArrayList<Favourites> favouritesList;
    private FavouritesAdapter adapter;
    private FragmentFavouritesBinding binding;
    private RecyclerView recyclerView;
    private Favourites favourites;
    private FavouritesViewModel favouritesViewModel;
    private FavouritesClickHandler clickHandler;
    private User user;

    public FavouritesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        clickHandler = new FavouritesClickHandler(this.getContext(), favourites, favouritesViewModel);
        binding.setFavourites(favourites);
        binding.setClickhandlers(clickHandler);
        getFavouritePlaces();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        adapter = new FavouritesAdapter(new ArrayList<>(), this.getContext());
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerview.setAdapter(adapter);
    }

    private void getFavouritePlaces(){
        favouritesViewModel.getAllFavourites(1L).observe(getViewLifecycleOwner(), favourites ->  {
            if(favourites != null){
                favouritesList = new ArrayList<>(favourites);
                adapter.setFavouritesList(favouritesList);
                adapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    public void onItemClick(int position) {

    }
}