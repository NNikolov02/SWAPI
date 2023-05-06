package com.swapi.swapi.Web.mapping;

import com.swapi.swapi.Web.Model.Starships;
import com.swapi.swapi.Web.dto.starships.StarshipsCreateRequest;
import com.swapi.swapi.Web.dto.starships.StarshipsResponse;
import com.swapi.swapi.Web.dto.starships.StarshipsUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {CharacterMapperDTO.class, FilmMapperDTO.class, PlanetsMapperDTO.class, SpeciesMapperDTO.class, VehicleMapperDTO.class})
public interface StarshipsMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "planets", ignore = true)
    Starships modelFromCreateRequest(StarshipsCreateRequest starshipsCreateDto);

    StarshipsResponse responseFromModel(Starships starships);

    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "MGLT", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "cargocapacity", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "consumables", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "edited", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "created", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "costincredits", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "crew", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "hyperdriverating", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "length", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "manufacturer", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "maxatmospheringspeed", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "model", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "passengers", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "url", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(StarshipsUpdateRequest starshipsUpdateDto, @MappingTarget Starships starships);

    List<StarshipsResponse> listOfModelToListOfDto(List<Starships> starships);

    List<StarshipsResponse> listOfModelToListOfDto(Iterable<Starships> all);
}
