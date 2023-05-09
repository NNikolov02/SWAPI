package com.swapi.swapi.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.swapi.swapi.dto.*;
import lombok.Builder;
import lombok.Data;

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



    private Set<String> character;

    private Set<String> starships;


    private Set<String> planets;


    private Set<String> vehicle;

    private Set<String> species;

}
