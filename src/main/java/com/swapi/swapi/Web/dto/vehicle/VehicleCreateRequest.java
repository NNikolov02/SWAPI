package com.swapi.swapi.Web.dto.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.swapi.Web.dto.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class VehicleCreateRequest {

    private String url;

    private String name;

    @JsonProperty("cargo_capacity")
    private String cargocapacity;
    private String consumables;
    @JsonProperty("cost_in_credits")
    private String costincredits;
    private String created;
    private String crew;
    private String edited;
    private String length;
    private String manufacturer;
    @JsonProperty("max_atmosphering_speed")
    private String max_tmospheringspeed;
    private String model;

    private String passengers;
    @JsonProperty("vehicle_class")
    private String vehicleclass;

    private Set<CharacterDto> character;

    private Set<SpeciesDto> species;


    private Set<PlanetsDto> planets;


    private Set<StarshipsDto> starships;

    private Set<FilmDto> films;
}
