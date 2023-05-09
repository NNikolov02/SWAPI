package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Planet;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PlanetsPagingRepository extends PagingAndSortingRepository<Planet, UUID> {

}

