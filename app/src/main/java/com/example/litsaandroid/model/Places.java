package com.example.litsaandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.litsaandroid.BR;

import java.util.List;

public class Places extends BaseObservable implements Parcelable {
    private int id;
    private String title;
    private String description;
    private String address;
    private int price;
    private List<String> keyWord;
    private String img;

    public Places() {
    }

    public Places(int id, String title, int price, List<String> keyWord, String address) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.keyWord = keyWord;
        this.address = address;
    }


    protected Places(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        address = in.readString();
        price = in.readInt();
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

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
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
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(address);
        dest.writeInt(price);
        dest.writeStringList(keyWord);
        dest.writeString(img);
    }
}
