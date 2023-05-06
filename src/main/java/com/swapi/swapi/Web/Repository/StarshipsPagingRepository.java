package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Species;
import com.swapi.swapi.Web.Model.Starships;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface StarshipsPagingRepository extends PagingAndSortingRepository<Starships, UUID> {

}