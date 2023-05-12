package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Species;
import com.swapi.swapi.dto.SpeciesDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpeciesMapperDTO {

    public static Set<String> speciesToStringUrls(Set<Species> species) {
        Set<String> urls = new HashSet<>();
        for (Species species1 : species) {
            urls.add(species1.getUrl());
        }
        return urls;
    }
    SpeciesDto modelRoDto(Species species);

    Species dtoModel(Species speciesDto);
}