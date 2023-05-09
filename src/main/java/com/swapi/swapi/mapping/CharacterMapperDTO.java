package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Character;
import com.swapi.swapi.dto.CharacterDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharacterMapperDTO {


    CharacterDto modelRoDto(Character character);

    Character dtoModel(Character characterDto);
}
