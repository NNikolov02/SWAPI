package com.swapi.swapi.Web.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.swapi.Web.dto.*;
import com.swapi.swapi.Web.dto.character.CharacterResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class FilmResponse {

    private UUID id;

    private String url;
    private String title;

    private String created;
    private String director;
    private String edited;
    @JsonProperty("episode_id")
    private int episodeId;
    @JsonProperty("opening_crawl")
    private String openingcrawl;

    private String producer;
    @JsonProperty("release_date")
    private String releasedate;



    private Set<CharacterDto> character;

    private Set<StarshipsDto> starships;


    private Set<PlanetsDto> planets;


    private Set<VehicleDto> vehicle;

    private Set<SpeciesDto> species;

}
