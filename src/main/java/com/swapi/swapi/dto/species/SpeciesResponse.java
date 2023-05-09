package com.swapi.swapi.dto.species;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.swapi.swapi.dto.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class SpeciesResponse {

    private UUID id;
    @JsonProperty("average_height")
    private String averageheight;

    private String url;
    @JsonProperty("average_lifespan")
    private String averagelifespan;
    private String classification;
    private String created;
    private String designation;
    private String edited;
    @JsonProperty("eye_colors")
    private String eyecolors;
    @JsonProperty("hair_colors")
    private String haircolors;
    private String homeworld;
    private String language;
    private String name;

    @JsonProperty("skin_colors")
    private String skincolors;

    private Set<String> character;

    private Set<String> starships;


    private Set<String> films;


    private Set<String> vehicle;

    private Set<String> planets;
}
