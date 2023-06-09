package com.swapi.swapi.dto.planets;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.swapi.swapi.dto.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class PlanetsUpdateRequest {
    private String url;
    private String climate;
    private String created;
    private String diameter;
    private String edited;

    private String gravity;
    private String name;
    @JsonProperty("orbital_period")
    private String orbitalperiod;
    private String population;

    @JsonProperty("rotation_period")
    private String rotation_period;
    @JsonProperty("surface_water")
    private String surface_water;
    private String terrain;


    private Set<String> character;

    private Set<String> starships;


    private Set<String> films;


    private Set<String> vehicle;

    private Set<String> species;;
}
