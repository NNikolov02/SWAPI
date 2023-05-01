package com.swapi.swapi.Web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CharacterDto {
    @JsonProperty("id")
    private UUID id;

    private String url;


    private String name;

    private String gender;


    private int height;

    private int mass;
    @JsonProperty("birth_year")
    private String birthYear;




}
