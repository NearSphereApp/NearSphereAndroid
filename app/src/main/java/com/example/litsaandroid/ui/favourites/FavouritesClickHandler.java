package com.example.litsaandroid.ui.favourites;

import android.content.Context;
import android.view.View;

import com.example.litsaandroid.model.Favourites;

public class FavouritesClickHandler {

    private Context context;
    private Favourites userFavouritePlace;
    private FavouritesViewModel favouritesViewModel;

    public FavouritesClickHandler(Context context, Favourites userFavouritePlace, FavouritesViewModel favouritesViewModel) {
        this.context = context;
        this.userFavouritePlace = userFavouritePlace;
        this.favouritesViewModel = favouritesViewModel;
    }

    //NOTE: check if better for addfavourites button logic to be here or in mainactivityclickhandler
    }

