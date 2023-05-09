package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Starship;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StarshipsRepository extends CrudRepository<Starship, UUID> {

}
