package com.swapi.swapi.Web.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.swapi.Web.dto.*;
import com.swapi.swapi.Web.dto.character.CharacterResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmCreateRequest {

    private String title;
    private String url;
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

    private CharacterDto character;

    private StarshipsDto starships;


    private PlanetsDto planets;


    private VehicleDto vehicle;

    private SpeciesDto species;
}
