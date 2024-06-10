package com.nura.futsalapp.model;

import java.util.ArrayList;

public class CaptainList {
    private ArrayList<CaptainDetails> captains;

    public CaptainList(ArrayList<CaptainDetails> captains) {
        this.captains = captains;
    }

    public ArrayList<CaptainDetails> getCaptains() {
        return captains;
    }

    public void setCaptains(ArrayList<CaptainDetails> captains) {
        this.captains = captains;
    }
}
