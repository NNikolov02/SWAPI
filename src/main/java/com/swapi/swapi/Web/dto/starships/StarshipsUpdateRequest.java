package com.swapi.swapi.Web.dto.starships;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.swapi.Web.dto.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class StarshipsUpdateRequest {

    private String url;
    private String name;

    private String MGLT;
    @JsonProperty("cargo_capacity")
    private String cargocapacity;


    private String consumables;

    @JsonProperty("cost_in_credits")
    private Long costincredits;

    private String created;
    private  Long crew;
    private String edited;
    @JsonProperty("hyperdrive_rating")
    private Float hyperdriverating;
    private Long length;
    private String manufacturer;

    @JsonProperty("max_atmosphering_speed")
    private String maxatmospheringspeed;
    private String model;
    private Long passengers;

    @JsonProperty("starship_class")
    private String starshipclass;

    private Set<CharacterDto> character;

    private Set<SpeciesDto> species;


    private Set<PlanetsDto> planets;


    private Set<VehicleDto> vehicle;

    private Set<FilmDto> films;
}
