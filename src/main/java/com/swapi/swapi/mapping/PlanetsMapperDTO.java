package com.swapi.swapi.mapping;


import com.swapi.swapi.Model.Planet;
import com.swapi.swapi.dto.PlanetsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlanetsMapperDTO {
    public static Set<String> planetToStringUrls(Set<Planet> planets) {
        Set<String> urls = new HashSet<>();
        for (Planet planet : planets) {
            urls.add(planet.getUrl());
        }
        return urls;
    }

    PlanetsDto modelRoDto(Planet planets);


   List<PlanetsDto>  modelsRoDto(Set<Planet> planets);


    Planet dtoModel(Planet planetsDto);
}

