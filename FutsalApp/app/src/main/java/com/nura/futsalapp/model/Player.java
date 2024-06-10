package com.nura.futsalapp.model;

import android.content.Context;
import android.util.Log;


public class Player {

    private static final String TAG = "Player";
    private String name ;
    private int rating;
    private String position ;
    private String nickName;
    private String jerseyNumber;
    private transient  int imageResId ;


    public Player() {
    }

    public Player(String name, int rating, String position, String nickName, String jerseyNumber) {
        this.name = name;
        this.rating = rating;
        this.position = position;
        this.nickName = nickName;
        this.jerseyNumber = jerseyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }


    public void resolveImageResId(Context context) {
        if (name != null) {
            String imageName = name.toLowerCase(); // Assuming the drawable resource names are in lowercase
            imageResId = context.getResources().getIdentifier(getNickName().toLowerCase(), "drawable", context.getPackageName());
            if (imageResId == 0) {
                Log.e(TAG, "Image resource not found for name: " + imageName);
            }
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", position='" + position + '\'' +
                ", nickName='" + nickName + '\'' +
                ", jerseyNo='" + jerseyNumber + '\'' +
                '}';
    }
}
