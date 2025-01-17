package com.example.litsaandroid.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.time.LocalDateTime;

public class Favourites extends BaseObservable {

    private Long id;
    private User user;
    private String googlePlaceId;
    private LocalDateTime addedAt;

    public Favourites() {
    }
    public Favourites(User user, String googlePlaceId) {
        this.user = user;
        this.googlePlaceId = googlePlaceId;
    }

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Bindable
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Bindable
    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }

    @Bindable
    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
