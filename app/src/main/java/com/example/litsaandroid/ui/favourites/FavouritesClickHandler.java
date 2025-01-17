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
    public void onClickFavouritesButton(View view){
        favouritesViewModel.addFavourites(userFavouritePlace);    }
    //TO-DO - decide if want to switch screen when favourites button clicked
    }

