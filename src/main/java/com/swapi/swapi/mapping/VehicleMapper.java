package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Starship;
import com.swapi.swapi.Model.Vehicle;
import com.swapi.swapi.dto.vehicle.VehicleCreateRequest;
import com.swapi.swapi.dto.vehicle.VehicleResponse;
import com.swapi.swapi.dto.vehicle.VehicleUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Mapper(uses = {CharacterMapperDTO.class, FilmMapperDTO.class, PlanetsMapperDTO.class, SpeciesMapperDTO.class, StarshipsMapperDTO.class})
public interface VehicleMapper {



    @Mapping(target = "id", ignore = true)
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "planets", ignore = true)
    Vehicle modelFromCreateRequest(VehicleCreateRequest vehicleCreateDto);

    VehicleResponse responseFromModel(Vehicle vehicle);

    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "cargocapacity", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "consumables", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "edited", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "created", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "costincredits", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "crew", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "length", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "manufacturer", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "max_tmospheringspeed", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "model", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "passengers", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "url", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(VehicleUpdateRequest vehicleUpdateDto, @MappingTarget Vehicle vehicle);

    List<VehicleResponse> listOfModelToListOfDto(List<Vehicle> vehicles);

    List<VehicleResponse> listOfModelToListOfDto(Iterable<Vehicle> all);
}