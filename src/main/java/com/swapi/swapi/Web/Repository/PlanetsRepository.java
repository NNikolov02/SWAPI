package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Planets;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlanetsRepository extends CrudRepository<Planets, UUID> {

}