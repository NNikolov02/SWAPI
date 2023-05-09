package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Vehicle;
import com.swapi.swapi.dto.VehicleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapperDTO {


    VehicleDto modelRoDto(Vehicle vehicle);

    Vehicle dtoModel(Vehicle vehicleDto);
}
