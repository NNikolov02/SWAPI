package com.swapi.swapi.Web.mapping;


import com.swapi.swapi.Web.Model.Planets;
import com.swapi.swapi.Web.dto.PlanetsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlanetsMapperDTO {


    PlanetsDto modelRoDto(Planets planets);


   List<PlanetsDto>  modelsRoDto(Set<Planets> planets);


    Planets dtoModel(Planets planetsDto);
}

