package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FilmRepository extends CrudRepository<Film, UUID> {

}