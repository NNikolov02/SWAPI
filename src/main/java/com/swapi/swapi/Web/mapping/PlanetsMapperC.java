package com.swapi.swapi.Web.mapping;

import com.swapi.swapi.Web.Model.Film;
import com.swapi.swapi.Web.Model.Planets;
import com.swapi.swapi.Web.dto.film.FilmCreateRequest;
import com.swapi.swapi.Web.dto.film.FilmResponse;
import com.swapi.swapi.Web.dto.film.FilmUpdateRequest;
import com.swapi.swapi.Web.dto.planets.PlanetsCreateRequest;
import com.swapi.swapi.Web.dto.planets.PlanetsUpdateRequest;
import com.swapi.swapi.Web.dto.planets.PlanetsrResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {CharacterMapperC.class, FilmMapper.class, SpeciesMapper.class,StarshipsMapper.class,VehicleMapper.class})
public interface PlanetsMapperC {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "species", ignore = true)
    Planets modelFromCreateRequest(PlanetsCreateRequest planetsCreateDto);

    PlanetsrResponse responseFromModel(Planets planets);
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "climate",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "created", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "diameter", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "edited", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "gravity", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "orbitalperiod", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "population", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "rotation_period", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "surface_water", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "terrain", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "url", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(PlanetsUpdateRequest planetsUpdateDto, @MappingTarget Planets planets);
    List<PlanetsrResponse> listOfModelToListOfDto(List<Planets>planets);

    List<PlanetsrResponse> listOfModelToListOfDto(Iterable<Planets> all);
}