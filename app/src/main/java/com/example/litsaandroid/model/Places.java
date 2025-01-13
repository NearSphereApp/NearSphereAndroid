package com.example.litsaandroid.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.litsaandroid.BR;

import java.util.List;

public class Places extends BaseObservable{
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
}
