package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface VehiclePagingRepository extends PagingAndSortingRepository<Vehicle, UUID> {

}