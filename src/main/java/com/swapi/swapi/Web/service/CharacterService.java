package com.swapi.swapi.Web.service;

import com.swapi.swapi.Web.Model.Character;
import com.swapi.swapi.Web.Repository.CharacterPagingRepository;
import com.swapi.swapi.Web.Repository.CharacterRepository;
import com.swapi.swapi.Web.error.NotFoundObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class CharacterService {
    @Autowired
    private CharacterRepository repo;

    @Autowired
    private CharacterPagingRepository pagingRepo;

    public Character save(Character character) {
        return repo.save(character);
    }

    public Page<Character> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Character findById(String characterId) {
        return repo.findById(UUID.fromString(characterId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Character Not Found", Character.class.getName(), characterId);
        });
    }

    public void deleteById(String characterId) {
        repo.deleteById(UUID.fromString(characterId));
    }
}
