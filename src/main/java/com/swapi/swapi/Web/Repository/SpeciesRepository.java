package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Species;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SpeciesRepository extends CrudRepository<Species, UUID> {

}