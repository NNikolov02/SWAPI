package com.swapi.swapi.Web.mapping;

import com.swapi.swapi.Web.Model.Vehicle;
import com.swapi.swapi.Web.dto.VehicleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {


    VehicleDto modelRoDto(Vehicle vehicle);

    Vehicle dtoModel(Vehicle vehicleDto);
}
