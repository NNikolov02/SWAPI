package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Character;
import com.swapi.swapi.dto.CharacterDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharacterMapperDTO {
    public static Set<String> charactersToStringUrls(Set<Character> characters) {
        Set<String> urls = new HashSet<>();
        for (Character character : characters) {
            urls.add(character.getUrl());
        }
        return urls;
    }

    CharacterDto modelRoDto(Character character);

    Character dtoModel(Character characterDto);
}
