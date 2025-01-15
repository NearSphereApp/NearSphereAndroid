package com.example.litsaandroid.ui.favourites;

import android.content.Context;
import android.view.View;

import com.example.litsaandroid.model.UserFavouritePlace;
import com.example.litsaandroid.ui.mainActivity.MainActivityViewModel;

public class FavouritesClickHandler {

    private Context context;
    private UserFavouritePlace userFavouritePlace;
    private FavouritesViewModel favouritesViewModel;


    public FavouritesClickHandler(Context context) {
        this.context = context;
    }

    public void onClickFavouritesButton(View view){
        favouritesViewModel.addFavourites(userFavouritePlace);    }
    //TO-DO - decide if want to switch screen when favourites button clicked
}
