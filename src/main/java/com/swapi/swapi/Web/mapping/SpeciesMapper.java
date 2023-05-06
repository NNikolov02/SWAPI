package com.swapi.swapi.Web.mapping;

import com.swapi.swapi.Web.Model.Species;
import com.swapi.swapi.Web.dto.species.SpeciesCreateRequest;
import com.swapi.swapi.Web.dto.species.SpeciesResponse;
import com.swapi.swapi.Web.dto.species.SpeciesUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {CharacterMapperDTO.class, FilmMapperDTO.class, PlanetsMapperDTO.class, StarshipsMapperDTO.class, VehicleMapperDTO.class})
public interface SpeciesMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "planets", ignore = true)
    Species modelFromCreateRequest(SpeciesCreateRequest speciesCreateDto);

    SpeciesResponse responseFromModel(Species species);
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "averageheight",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "averagelifespan", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "classification", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "edited", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "created", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "designation", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "eyecolors", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "haircolors", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "homeworld", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "language", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "url", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(SpeciesUpdateRequest speciesUpdateDto, @MappingTarget Species species);
    List<SpeciesResponse> listOfModelToListOfDto(List<Species>species);

    List<SpeciesResponse> listOfModelToListOfDto(Iterable<Species> all);
}