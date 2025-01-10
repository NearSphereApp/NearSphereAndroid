package com.example.litsaandroid.model;

import androidx.databinding.BaseObservable;

import java.util.List;

public class Places extends BaseObservable{
    private String title;
    private String description;
    private int price;
    private List<String> keyWord;
    private String img;

    public Places() {
    }

    public Places(String title, String description, int price, List<String> keyWord, String img) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.keyWord = keyWord;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(List<String> keyWord) {
        this.keyWord = keyWord;
    }
}
