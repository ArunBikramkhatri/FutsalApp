package com.nura.futsalapp.model;

import android.app.Activity;
import android.content.Context;

public class GoalScorer {

    private String name;
    private int goals;
    private int imgId;

    public GoalScorer() {
    }

    public GoalScorer(Context context , String name, int goals) {
        this.name = name;
        this.goals = goals;
        imgId = context.getResources().getIdentifier(name.toLowerCase(), "drawable", context.getPackageName());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
