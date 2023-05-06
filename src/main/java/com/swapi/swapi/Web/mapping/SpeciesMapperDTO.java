package com.swapi.swapi.Web.mapping;

import com.swapi.swapi.Web.Model.Species;
import com.swapi.swapi.Web.dto.SpeciesDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpeciesMapperDTO {


    SpeciesDto modelRoDto(Species species);

    Species dtoModel(Species speciesDto);
}