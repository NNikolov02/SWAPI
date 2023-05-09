package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Species;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface SpeciesPagingRepository extends PagingAndSortingRepository<Species, UUID> {

}
