package com.swapi.swapi.Repository;

import com.swapi.swapi.Model.Character;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;


public interface CharacterPagingRepository extends PagingAndSortingRepository<Character, UUID> {

}
