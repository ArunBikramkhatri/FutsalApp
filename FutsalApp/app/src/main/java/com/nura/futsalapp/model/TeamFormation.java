package com.nura.futsalapp.model;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class TeamFormation {

    private static final String TAG = "TeamFormation";
    private String teamDetails;
    private JSONObject teams;

    private ArrayList<Player> playerArrayList;

    private ArrayList<Player> teamOne, teamTwo;


    private ArrayList<Player> keepers  ;
    public TeamFormation(ArrayList<Player> players) {
        this.playerArrayList = players;
        teamOne = new ArrayList<>();
        teamTwo = new ArrayList<>();
        keepers = new ArrayList<>();
    }

    public ArrayList<Player> getTeamOne() {
        return teamOne;
    }

    public ArrayList<Player> getTeamTwo() {
        return teamTwo;
    }


    public void makeTeam(int range) {
        Random random = new Random();

        float toss = random.nextFloat();
        boolean teamOneChoose = false;
        if (toss > 0.5) {
            teamOneChoose = true;
        }
        if (playerArrayList.size() == 1) {
            if (teamOneChoose) {
                teamOne.add(playerArrayList.get(0));

            } else {
                teamTwo.add(playerArrayList.get(0));
            }
            return;
        }
        for (int i = 0; i < range; i++) {
            int x = 0, y = 0;

            if (playerArrayList.size() >=  4) {
                x = random.nextInt(4);
            } else {
                x = random.nextInt(playerArrayList.size());
            }

            teamOne.add(playerArrayList.get(x));
            playerArrayList.remove(x);
            if (playerArrayList.size() >=  4) {
                y = random.nextInt(4);
            } else {
                y = random.nextInt(playerArrayList.size());
            }
            teamTwo.add(playerArrayList.get(y));
            playerArrayList.remove(y);
        }
    }

    public void createTeam() {

        Iterator<Player> iterator = playerArrayList.iterator();
        while (iterator.hasNext()) {
            Player p = iterator.next();
            Log.d(TAG, "createTeam: " + p.toString());
            if (p.getPosition().equals("GK")) {
                keepers.add(p);
                iterator.remove(); // Use iterator.remove() to safely remove from ArrayList
            }
        }
        while (playerArrayList.size() != 0) {
            if (playerArrayList.size() >= 4) {
                makeTeam(2);
            } else {
                if (playerArrayList.size() % 2 == 0 && playerArrayList.size() > 0) {
                    makeTeam(1);
                } else if (playerArrayList.size() > 1) {
                    makeTeam(1);
                } else {
                    makeTeam(1);
                    break;
                }
            }
        }
        if (keepers != null && keepers.size() == 2){
        teamOne.add(keepers.get(0));
        teamTwo.add(keepers.get(1));}
    }

}
