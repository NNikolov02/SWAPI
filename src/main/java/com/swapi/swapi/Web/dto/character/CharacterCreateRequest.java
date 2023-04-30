package com.swapi.swapi.Web.dto.character;

import com.swapi.swapi.Web.dto.*;
import com.swapi.swapi.Web.dto.FilmDto;
import com.swapi.swapi.Web.validation.ValidGender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterCreateRequest {
    private String name;

    @ValidGender(message = "Character should be male or female")
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
