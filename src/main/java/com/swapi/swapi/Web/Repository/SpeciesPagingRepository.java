package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Planets;
import com.swapi.swapi.Web.Model.Species;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface SpeciesPagingRepository extends PagingAndSortingRepository<Species, UUID> {

}
