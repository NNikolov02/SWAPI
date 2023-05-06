package com.swapi.swapi.Web.dto.species;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.swapi.Web.dto.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class SpeciesUpdateRequest {

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

    private Set<CharacterDto> character;

    private Set<StarshipsDto> starships;


    private Set<PlanetsDto> planets;


    private Set<VehicleDto> vehicle;

    private Set<FilmDto> films;
}
