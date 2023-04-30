package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Character;
import com.swapi.swapi.Web.Model.Film;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface FilmPagingRepository extends PagingAndSortingRepository<Film, UUID> {

}
