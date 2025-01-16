package com.example.litsaandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.litsaandroid.BR;

import java.util.List;

public class Places extends BaseObservable implements Parcelable {
    private String id;
    private String title;
    private String description;
    private String price;
    private Double latitude;
    private Double longitude;
    private Double radius;
    private List<String> keyWord;
    private String img;

    public Places() {
    }

    public Places(Double latitude, Double longitude, Double radius, List<String> keyWord) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.keyWord = keyWord;
    }

    public Places(String id, Double radius, String title, String price, Double latitude, Double longitude, List<String> keyWord) {
        this.id = id;
        this.radius = radius;
        this.title = title;
        this.price = price;
        this.latitude = latitude;
        this.longitude = longitude;
        this.keyWord = keyWord;
    }


    protected Places(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
//        address = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        radius = in.readDouble();
        price = in.readString();
        keyWord = in.createStringArrayList();
        img = in.readString();
    }

    public static final Creator<Places> CREATOR = new Creator<Places>() {
        @Override
        public Places createFromParcel(Parcel in) {
            return new Places(in);
        }

        @Override
        public Places[] newArray(int size) {
            return new Places[size];
        }
    };



    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Bindable
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

        notifyPropertyChanged(BR.title);}

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);

    }

    @Bindable
    public List<String> getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(List<String> keyWord) {
        this.keyWord = keyWord;
        notifyPropertyChanged(BR.keyWord);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(price);
        dest.writeStringList(keyWord);
        dest.writeString(img);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }
}