package com.swapi.swapi.Web.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.swapi.Web.dto.PlanetsDto;
import com.swapi.swapi.Web.dto.SpeciesDto;
import com.swapi.swapi.Web.dto.StarshipsDto;
import com.swapi.swapi.Web.dto.VehicleDto;
import com.swapi.swapi.Web.dto.character.CharacterResponse;
import lombok.Builder;
import lombok.Data;

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

    private CharacterResponse character;

    private StarshipsDto starships;


    private PlanetsDto planets;


    private VehicleDto vehicle;

    private SpeciesDto species;

}
