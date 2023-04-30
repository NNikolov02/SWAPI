package com.swapi.swapi.Web.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.swapi.Web.dto.*;
import com.swapi.swapi.Web.dto.FilmDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CharacterResponse {
    @JsonProperty("id")
    private UUID id;


    private String name;

    private String gender;

    private SpeciesDto species;

    private int height;

    private int mass;
    @JsonProperty("birth_year")
    private String birthYear;


    private FilmDto film;


    private StarshipsDto starships;


    private PlanetsDto planets;


    private VehicleDto vehicle;
}
