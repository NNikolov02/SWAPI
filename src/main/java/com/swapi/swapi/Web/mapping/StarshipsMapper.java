package com.swapi.swapi.Web.mapping;

import com.swapi.swapi.Web.Model.Starships;
import com.swapi.swapi.Web.dto.StarshipsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StarshipsMapper {


    StarshipsDto modelRoDto(Starships starships);

    Starships dtoModel(Starships starshipsDto);
}