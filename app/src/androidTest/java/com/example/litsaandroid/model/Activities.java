package com.example.litsaandroid.model;

import androidx.databinding.BaseObservable;

import java.util.List;

public class Activities extends BaseObservable{
    private String title;
    private String description;
    private int price;
    private List<String> tag;
    private String img;

    public Activities() {
    }

    public Activities(String title, String description, int price, List<String> tag, String img) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.tag = tag;
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

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }
}
