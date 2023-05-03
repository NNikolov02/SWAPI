package com.swapi.swapi.Web.dto.planets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.swapi.Web.dto.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlanetsCreateRequest {

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
    private CharacterDto character;

    private StarshipsDto starships;


    private FilmDto film;


    private VehicleDto vehicle;

    private SpeciesDto species;
}
