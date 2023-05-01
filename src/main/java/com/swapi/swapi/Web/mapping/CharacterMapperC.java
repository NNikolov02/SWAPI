package com.swapi.swapi.Web.mapping;

import com.swapi.swapi.Web.Model.Character;
import com.swapi.swapi.Web.dto.character.CharacterCreateRequest;
import com.swapi.swapi.Web.dto.character.CharacterResponse;
import com.swapi.swapi.Web.dto.character.CharacterUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {FilmMapper.class, PlanetsMapper.class, SpeciesMapper.class,StarshipsMapper.class,VehicleMapper.class})
public interface CharacterMapperC {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "species", ignore = true)
    Character modelFromCreateRequest(CharacterCreateRequest characterCreateDto);

    CharacterResponse responseFromModel(Character character);
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "gender",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "birthYear", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "mass", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "height", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "url",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(CharacterUpdateRequest characterUpdateDto, @MappingTarget Character character);
    List<CharacterResponse> listOfModelToListOfDto(List<Character>character);

    List<CharacterResponse> listOfModelToListOfDto(Iterable<Character> all);
}
