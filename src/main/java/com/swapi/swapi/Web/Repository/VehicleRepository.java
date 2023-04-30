package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {

}