package com.example.litsaandroid.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.time.LocalDateTime;

public class Favourites extends BaseObservable {

    private Long id;

    private String displayName;

    private String img;

    private String formattedAddress;

    private String websiteUri;

    private String priceLevel;

    public Favourites() {
    }

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Bindable
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Bindable
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Bindable
    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @Bindable
    public String getWebsiteUri() {
        return websiteUri;
    }

    public void setWebsiteUri(String websiteUri) {
        this.websiteUri = websiteUri;
    }

    @Bindable
    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }
}



