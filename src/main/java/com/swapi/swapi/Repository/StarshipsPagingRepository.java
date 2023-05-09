package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Starship;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface StarshipsPagingRepository extends PagingAndSortingRepository<Starship, UUID> {

}