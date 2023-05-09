package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Planet;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlanetsRepository extends CrudRepository<Planet, UUID> {

}