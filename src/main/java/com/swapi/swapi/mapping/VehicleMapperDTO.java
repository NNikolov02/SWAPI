package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.Vehicle;
import com.swapi.swapi.dto.VehicleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapperDTO {

   public static Set<String> vehicleToStringUrls(Set<Vehicle> vehicles) {
        Set<String> urls = new HashSet<>();
        for (Vehicle vehicle : vehicles) {
            urls.add(vehicle.getUrl());
        }
        return urls;
    }
    VehicleDto modelRoDto(Vehicle vehicle);

    Vehicle dtoModel(Vehicle vehicleDto);
}
