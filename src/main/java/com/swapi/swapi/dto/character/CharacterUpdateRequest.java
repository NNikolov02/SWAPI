package com.swapi.swapi.dto.character;


import com.swapi.swapi.dto.*;
import com.swapi.swapi.validation.ValidGender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CharacterUpdateRequest {
    private String name;
    private String url;

    @ValidGender(message = "Character should be male or female")
    private String gender;



    private int height;

    private int mass;
    @JsonProperty("birth_year")
    private String birthYear;

    private Set<String> films;

    private Set<String> starships;


    private Set<String> planets;


    private Set<String> vehicle;

    private Set<String> species;
}
