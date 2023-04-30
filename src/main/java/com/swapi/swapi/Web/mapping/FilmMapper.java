package com.swapi.swapi.Web.mapping;

import com.swapi.swapi.Web.Model.Film;
import com.swapi.swapi.Web.dto.FilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FilmMapper {


    FilmDto modelRoDto(Film film);

    Film dtoModel(Film filmDto);
}
