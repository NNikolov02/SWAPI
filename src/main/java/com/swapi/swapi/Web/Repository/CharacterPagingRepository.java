package com.swapi.swapi.Web.Repository;

import com.swapi.swapi.Web.Model.Character;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;


public interface CharacterPagingRepository extends PagingAndSortingRepository<Character, UUID> {

}
