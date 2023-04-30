package com.swapi.swapi.Web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PlanetsDto {

    private UUID id;

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
}
