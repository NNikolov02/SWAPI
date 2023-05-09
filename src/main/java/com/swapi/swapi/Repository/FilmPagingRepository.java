package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Film;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface FilmPagingRepository extends PagingAndSortingRepository<Film, UUID> {

}
