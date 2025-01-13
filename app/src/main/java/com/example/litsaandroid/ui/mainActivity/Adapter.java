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

    public Adapter(List<Places> placesList, Context context) {
        this.placesList = placesList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlacesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PlacesItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.places_item,
                parent,
                false);
        return new PlacesItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesItemViewHolder holder, int position) {
    Places place = placesList.get(position);
    holder.placesItemBinding.setPlaces(place);
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    public static class PlacesItemViewHolder extends RecyclerView.ViewHolder {

        private PlacesItemBinding placesItemBinding;

        public PlacesItemViewHolder(PlacesItemBinding placesItemBinding) {
            super(placesItemBinding.getRoot());
            this.placesItemBinding = placesItemBinding;
        }
    }
}
