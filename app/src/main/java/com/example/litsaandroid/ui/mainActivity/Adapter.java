package com.example.litsaandroid.ui.mainActivity;


import android.content.Context;
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
import com.example.litsaandroid.ui.favourites.FavouritesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PlacesItemViewHolder> {
    private List<Places> placesList;
    private Context context;
    private Favourites favourites;

    private FavouritesViewModel favouritesViewModel;

    private final RecyclerViewInterface recyclerViewInterface;

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

        Glide.with(holder.itemView.getContext())
                .load(place.getImg())
                .placeholder(R.drawable.place_image)
                .fitCenter()
                .into(holder.binding.placesImage);

//        switch(place.getPriceLevel()) {
//            case "1":
//                holder.binding.price.setImageResource(R.drawable.one_pound);
//                break;
//            case "2":
//                holder.binding.price.setImageResource(R.drawable.two_pound);
//                break;
//            case "3":
//                holder.binding.price.setImageResource(R.drawable.three_pound);
//                break;
//            case "4":
//                holder.binding.price.setImageResource(R.drawable.four_pound);
//                break;
//            default:
//                holder.binding.price.setImageResource(R.drawable.ic_price_foreground);
//        }


    FloatingActionButton favouritesButton = holder.binding.floatingActionButtonFavourites;
    favouritesButton.setSelected(true);
    favouritesButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

//            favourites.setId(place.getId());

//            favourites.setDisplayName(place.getDisplayName());
//            favourites.setImg(place.getImg());
//            favourites.setFormattedAddress(place.getFormattedAddress());
//            favourites.setPriceLevel(place.getPriceLevel());
//            favourites.setWebsiteUri(place.getWebsiteUri());
//            favourites.setTypes(place.getTypes());

//            favouritesViewModel.addFavourites(favourites);

            if(favouritesButton.isSelected()){
                favouritesButton.setImageResource(R.drawable.favourites_clicked);
                favouritesButton.setSelected(false);
            }
            else{
                favouritesButton.setImageResource(R.drawable.favourites_unclicked);
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
