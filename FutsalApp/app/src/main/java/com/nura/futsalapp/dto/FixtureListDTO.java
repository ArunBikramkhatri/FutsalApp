package com.nura.futsalapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class FixtureListDTO {

    @JsonProperty("fixtures")
    private ArrayList<FixtureDTO> fixtureDTOS ;

    public ArrayList<FixtureDTO> getFixtureDTOS() {
        return fixtureDTOS;
    }

    public void setFixtureDTOS(ArrayList<FixtureDTO> fixtureDTOS) {
        this.fixtureDTOS = fixtureDTOS;
    }
}
