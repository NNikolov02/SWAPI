package com.swapi.swapi.service;


import com.swapi.swapi.Model.Starship;
import com.swapi.swapi.Repository.StarshipsPagingRepository;
import com.swapi.swapi.Repository.StarshipsRepository;
import com.swapi.swapi.error.NotFoundObjectException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class StarshipsService {
    @Autowired
    private StarshipsRepository repo;

    @Autowired
    private StarshipsPagingRepository pagingRepo;

    public Starship save(Starship starships) {

        return repo.save(starships);
    }

    public Page<Starship> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Starship findById(String starshipsId) {
        return repo.findById(UUID.fromString(starshipsId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Starship Not Found", Starship.class.getName(), starshipsId);
        });
    }

    public void deleteById(String starshipsId) {
        repo.deleteById(UUID.fromString(starshipsId));

    }
}