package com.swapi.swapi.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.swapi.swapi.dto.*;
import com.swapi.swapi.validation.ValidGender;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class CharacterResponse {
    @JsonProperty("id")
    private UUID id;

    private String url;


    private String name;
    @ValidGender(message = "Character should be male or female!")
    private String gender;



    private int height;
    @Range(min = 0, max = 300, message = "i like mass from 0 to 300")
    private int mass;
    @JsonProperty("birth_year")
    private String birthYear;





    private Set<String> films;

    private Set<String> starships;


    private Set<String> planets;


    private Set<String> vehicle;

    private Set<String> species;
}
