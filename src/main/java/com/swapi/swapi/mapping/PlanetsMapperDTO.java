package com.swapi.swapi.mapping;


import com.swapi.swapi.Model.Planet;
import com.swapi.swapi.dto.PlanetsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlanetsMapperDTO {


    PlanetsDto modelRoDto(Planet planets);


   List<PlanetsDto>  modelsRoDto(Set<Planet> planets);


    Planet dtoModel(Planet planetsDto);
}

