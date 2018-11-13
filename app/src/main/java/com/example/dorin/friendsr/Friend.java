package com.example.dorin.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {

    private String name, bio;
    private int drawableId;
    private float rating;

    public Friend(String aName, String aBio, Integer aDrawableId) {
        name = aName;
        bio = aBio;
        drawableId = aDrawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public Integer getDrawableId() {
        return drawableId;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
