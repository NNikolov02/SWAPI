package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {

}