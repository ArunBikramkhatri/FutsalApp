package com.nura.futsalapp.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TeamFormation {

    private String teamDetails;
    private JSONObject teams;

    private ArrayList<Player> playerArrayList;

    private ArrayList<Player> teamOne, teamTwo;


    public TeamFormation(ArrayList<Player> players) {
        this.playerArrayList = players;
        teamOne = new ArrayList<>();
        teamTwo = new ArrayList<>();
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

            if (range == 2) {
                x = random.nextInt(4);
            } else {
                x = random.nextInt(playerArrayList.size());
            }

            teamOne.add(playerArrayList.get(x));
            playerArrayList.remove(x);
            if (range == 2) {
                y = random.nextInt(4);
            } else {
                y = random.nextInt(playerArrayList.size());
            }
            teamTwo.add(playerArrayList.get(y));
            playerArrayList.remove(y);
        }
    }

    public void createTeam() {
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
    }


}
