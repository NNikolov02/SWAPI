package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Species;
import com.swapi.swapi.dto.SpeciesDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpeciesMapperDTO {


    SpeciesDto modelRoDto(Species species);

    Species dtoModel(Species speciesDto);
}