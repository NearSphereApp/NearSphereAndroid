package com.example.litsaandroid.ui.favourites;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.litsaandroid.model.UserFavouritePlace;
import com.example.litsaandroid.model.UserFavouriteRepository;

import java.util.List;

public class FavouritesViewModel extends AndroidViewModel {

    private UserFavouriteRepository userFavouriteRepository;


    public FavouritesViewModel(@NonNull Application application) {
        super(application);
        this.userFavouriteRepository = new UserFavouriteRepository(application);
    }

    public MutableLiveData<List<UserFavouritePlace>> getAllFavourites(){
        //TO-DO - add logic
        return new MutableLiveData<>();
    }

    public void addFavourites(UserFavouritePlace userFavouritePlace){
        userFavouriteRepository.addFavourite();
        //TO-DO - add logic in addfavourite method
    }

    public void deleteFavourites(){
        userFavouriteRepository.deleteFavourite();
        //TO-DO - add logic in deletefavourite method
    }
}
