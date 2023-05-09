package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Species;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SpeciesRepository extends CrudRepository<Species, UUID> {

}