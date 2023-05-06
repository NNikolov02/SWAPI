package com.swapi.swapi.Web.service;

import com.swapi.swapi.Web.Model.Species;

import com.swapi.swapi.Web.Repository.SpeciesPagingRepository;
import com.swapi.swapi.Web.Repository.SpeciesRepository;
import com.swapi.swapi.Web.error.NotFoundObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class SpeciesService {
    @Autowired
    private SpeciesRepository repo;

    @Autowired
    private SpeciesPagingRepository pagingRepo;

    public Species save(Species species) {

        return repo.save(species);
    }

    public Page<Species> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Species findById(String speciesId) {
        return repo.findById(UUID.fromString(speciesId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Species Not Found",Species.class.getName(), speciesId);
        });
    }

    public void deleteById(String speciesId) {
        repo.deleteById(UUID.fromString(speciesId));

    }
}