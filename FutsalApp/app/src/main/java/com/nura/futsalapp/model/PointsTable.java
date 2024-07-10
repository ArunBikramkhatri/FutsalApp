package com.nura.futsalapp.model;

import android.content.Context;
import android.util.Log;

public class PointsTable {
    private String captainName;
    private String win;
    private String draw;
    private String lose;
    private String points;
    private int logoId;


    public PointsTable(Context context, String captainName, String win, String draw, String lose, String points) {
        this.captainName = captainName;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
        this.points = points;
        String logoName = captainName.toLowerCase() + "team";

        logoId = context.getResources().getIdentifier(logoName, "mipmap", context.getPackageName());
    }

    public int getLogoId() {
        return logoId;
    }

    public void setLogoId(int logoId) {
        this.logoId = logoId;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getLose() {
        return lose;
    }

    public void setLose(String lose) {
        this.lose = lose;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
