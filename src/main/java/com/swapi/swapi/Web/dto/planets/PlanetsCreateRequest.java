package com.swapi.swapi.Web.dto.planets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.swapi.Web.dto.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class PlanetsCreateRequest {
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

    private Set<CharacterDto> character;

    private Set<StarshipsDto> starships;


    private Set<FilmDto> film;


    private Set<VehicleDto> vehicle;

    private Set<SpeciesDto> species;
}
