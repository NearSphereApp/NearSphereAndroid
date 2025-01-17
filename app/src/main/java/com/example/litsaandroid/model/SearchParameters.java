package com.example.litsaandroid.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class SearchParameters implements Parcelable {
    private double latitude;
    private double longitude;
    private double radius;
    private List<String> keywords;

    public SearchParameters() {
    }

    public SearchParameters(double latitude, double longitude, double radius, List<String> keywords) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.keywords = keywords;
    }

    protected SearchParameters(Parcel in) {
        latitude = in.readDouble();
        longitude = in.readDouble();
        radius = in.readDouble();
        keywords = in.createStringArrayList();
    }

    public static final Creator<SearchParameters> CREATOR = new Creator<SearchParameters>() {
        @Override
        public SearchParameters createFromParcel(Parcel in) {
            return new SearchParameters(in);
        }

        @Override
        public SearchParameters[] newArray(int size) {
            return new SearchParameters[size];
        }
    };

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeDouble(radius);
        dest.writeStringList(keywords);
    }
}
