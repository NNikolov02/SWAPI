package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Film;
import com.swapi.swapi.dto.FilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FilmMapperDTO {


    FilmDto modelRoDto(Film film);

    Film dtoModel(Film filmDto);
}
