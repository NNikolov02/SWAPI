package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Character;
import com.swapi.swapi.Web.Model.Planets;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PlanetsPagingRepository extends PagingAndSortingRepository<Planets, UUID> {

}

