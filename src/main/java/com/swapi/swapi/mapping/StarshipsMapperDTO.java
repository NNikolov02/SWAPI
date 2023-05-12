package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Starship;
import com.swapi.swapi.dto.StarshipsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StarshipsMapperDTO {
    public static Set<String> starshipToStringUrls(Set<Starship> starships) {
        Set<String> urls = new HashSet<>();
        for (Starship starship : starships) {
            urls.add(starship.getUrl());
        }
        return urls;
    }


    StarshipsDto modelRoDto(Starship starships);

    Starship dtoModel(Starship starshipsDto);
}