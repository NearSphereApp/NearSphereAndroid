package com.example.litsaandroid.ui.mainActivity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.litsaandroid.R;
import com.example.litsaandroid.databinding.PlacesItemBinding;
import com.example.litsaandroid.model.Places;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PlacesItemViewHolder> {
    private List<Places> placesList;
    private Context context;

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
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }



    public void setPlacesList(List<Places> placesList) {
        this.placesList = placesList;
    }
}
