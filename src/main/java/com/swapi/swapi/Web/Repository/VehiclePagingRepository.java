package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Starships;
import com.swapi.swapi.Web.Model.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface VehiclePagingRepository extends PagingAndSortingRepository<Vehicle, UUID> {

}