package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Character;
import com.swapi.swapi.Model.Film;
import com.swapi.swapi.dto.film.FilmCreateRequest;
import com.swapi.swapi.dto.film.FilmResponse;
import com.swapi.swapi.dto.film.FilmUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Mapper(uses = {CharacterMapperDTO.class, PlanetsMapperDTO.class, SpeciesMapperDTO.class, StarshipsMapperDTO.class, VehicleMapperDTO.class})
public interface FilmMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "species", ignore = true)
    Film modelFromCreateRequest(FilmCreateRequest filmCreateDto);

    FilmResponse responseFromModel(Film film);
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "title",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "created", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "director", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "episodeId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "openingcrawl", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "producer", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "releasedate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "url", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(FilmUpdateRequest filmUpdateDto, @MappingTarget Film film);
    List<FilmResponse> listOfModelToListOfDto(List<Film>film);

    List<FilmResponse> listOfModelToListOfDto(Iterable<Film> all);
}