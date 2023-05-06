package com.swapi.swapi.Web.service;


import com.swapi.swapi.Web.Model.Starships;
import com.swapi.swapi.Web.Repository.StarshipsPagingRepository;
import com.swapi.swapi.Web.Repository.StarshipsRepository;
import com.swapi.swapi.Web.error.NotFoundObjectException;

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

    public Starships save(Starships starships) {

        return repo.save(starships);
    }

    public Page<Starships> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Starships findById(String starshipsId) {
        return repo.findById(UUID.fromString(starshipsId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Starship Not Found",Starships.class.getName(), starshipsId);
        });
    }

    public void deleteById(String starshipsId) {
        repo.deleteById(UUID.fromString(starshipsId));

    }
}