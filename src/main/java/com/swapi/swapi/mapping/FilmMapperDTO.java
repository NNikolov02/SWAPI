package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Film;
import com.swapi.swapi.dto.FilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FilmMapperDTO {

    public static Set<String> filmsToStringUrls(Set<Film> films) {
        Set<String> urls = new HashSet<>();
        for (Film film : films) {
            urls.add(film.getUrl());
        }
        return urls;
    }

    FilmDto modelRoDto(Film film);

    Film dtoModel(Film filmDto);
}
