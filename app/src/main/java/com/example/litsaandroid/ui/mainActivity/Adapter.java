package com.example.litsaandroid.ui.mainActivity;


import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.litsaandroid.R;
import com.example.litsaandroid.databinding.PlacesItemBinding;
import com.example.litsaandroid.model.Favourites;
import com.example.litsaandroid.model.Places;


import com.example.litsaandroid.model.User;
import com.example.litsaandroid.ui.favourites.FavouritesFragment;
import com.example.litsaandroid.ui.favourites.FavouritesViewModel;
import com.example.litsaandroid.user.UserViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PlacesItemViewHolder> {
    private List<Places> placesList;
    private Context context;
    private Favourites favourites;
    private FavouritesViewModel favouritesViewModel;
    private FavouritesFragment favouritesFragment;
    private final RecyclerViewInterface recyclerViewInterface;
    private Favourites newFavourite = new Favourites();

    private Application application;

    public Adapter(List<Places> placesList, RecyclerViewInterface recyclerViewInterface) {
        this.placesList = placesList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public static class PlacesItemViewHolder extends RecyclerView.ViewHolder{
        private PlacesItemBinding binding;

        public PlacesItemViewHolder(PlacesItemBinding placesItemBinding,
                                RecyclerViewInterface recyclerViewInterface){
            super(placesItemBinding.getRoot());
            this.binding = placesItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface!= null){
                        int position = getAdapterPosition();
                        if (position!= RecyclerView.NO_POSITION)
                            recyclerViewInterface.onItemClick(position);
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public PlacesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PlacesItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.places_item,
                parent,
                false);
        return new PlacesItemViewHolder(binding, recyclerViewInterface);}

    @Override
    public void onBindViewHolder(@NonNull PlacesItemViewHolder holder, int position) {
    Places place = placesList.get(position);
    holder.binding.setPlaces(place);

    FloatingActionButton favouritesButton = holder.binding.floatingActionButtonFavourites;
    favouritesButton.setSelected(true);
    favouritesButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            newFavourite.setDisplayName(place.getDisplayName());
            newFavourite.setPhotoLink(place.getImg());
            newFavourite.setFormattedAddress(place.getFormattedAddress());
            newFavourite.setWebsite(place.getWebsiteUri());
            newFavourite.setPriceLevel(place.getPriceLevel());
            newFavourite.setTypes(place.getTypes());
            newFavourite.setUserId(1L);

            if (place.getPriceLevel() != null) {
                newFavourite.setPriceLevel(place.getPriceLevel());
            } else {
                newFavourite.setPriceLevel("PRICE_LEVEL_UNSPECIFIED");}

            if (place.getWebsiteUri() != null) {
                newFavourite.setPhotoLink(place.getImg());
            } else {
                newFavourite.setPhotoLink("empty");}

            if (place.getWebsiteUri() != null) {
                newFavourite.setWebsite(place.getWebsiteUri());
            } else {
                newFavourite.setWebsite("empty");}

                Log.i("favourites", newFavourite.getPhotoLink());
                Log.i("favourites", newFavourite.getDisplayName());
                Log.i("favourites", newFavourite.getFormattedAddress());
                Log.i("favourites", newFavourite.getWebsite());
                Log.i("favourites", newFavourite.getPriceLevel());
                Log.i("favourites", newFavourite.getTypesAsString());

            favouritesViewModel = new FavouritesViewModel(new Application());
            favouritesViewModel.addFavourites(1L, newFavourite);

            if(favouritesButton.isSelected()){
                favouritesButton.setImageResource(R.drawable.fav_click_foreground);
                favouritesButton.setSelected(false);
            }
            else{
                favouritesButton.setImageResource(R.drawable.fav_unclick_foreground);
                favouritesButton.setSelected(true);
            }
        }
    });
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    public void setPlacesList(List<Places> placesList) {
        this.placesList = placesList;
    }
}
