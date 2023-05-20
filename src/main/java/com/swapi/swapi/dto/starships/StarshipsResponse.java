package com.swapi.swapi.dto.starships;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.swapi.swapi.dto.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class StarshipsResponse {
    private UUID id;

    private String url;
    public String getUrl() {
        return "http://localhost:8081/" + "starships" + "/" + id.toString();
    }
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

    private Set<String> character;

    private Set<String> species;


    private Set<String> films;


    private Set<String> vehicle;

    private Set<String> planets;
}
