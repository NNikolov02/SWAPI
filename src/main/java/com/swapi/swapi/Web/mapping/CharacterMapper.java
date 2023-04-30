package com.swapi.swapi.Web.mapping;

import com.swapi.swapi.Web.Model.Character;
import com.swapi.swapi.Web.Model.Planets;
import com.swapi.swapi.Web.dto.CharacterDto;
import com.swapi.swapi.Web.dto.PlanetsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharacterMapper {


    CharacterDto modelRoDto(Character character);

    Character dtoModel(Character characterDto);
}
