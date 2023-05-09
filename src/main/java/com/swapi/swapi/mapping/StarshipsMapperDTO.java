package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Starship;
import com.swapi.swapi.dto.StarshipsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StarshipsMapperDTO {


    StarshipsDto modelRoDto(Starship starships);

    Starship dtoModel(Starship starshipsDto);
}