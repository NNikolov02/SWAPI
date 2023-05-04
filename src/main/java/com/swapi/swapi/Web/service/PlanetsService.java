package com.swapi.swapi.Web.service;

import com.swapi.swapi.Web.Model.Film;
import com.swapi.swapi.Web.Model.Planets;
import com.swapi.swapi.Web.Repository.FilmPagingRepository;
import com.swapi.swapi.Web.Repository.FilmRepository;
import com.swapi.swapi.Web.Repository.PlanetsPagingRepository;
import com.swapi.swapi.Web.Repository.PlanetsRepository;
import com.swapi.swapi.Web.error.NotFoundObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class PlanetsService {
    @Autowired
    private PlanetsRepository repo;

    @Autowired
    private PlanetsPagingRepository pagingRepo;

    public Planets save(Planets planets) {

        return repo.save(planets);
    }

    public Page<Planets> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Planets findById(String planetsId) {
        return repo.findById(UUID.fromString(planetsId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Planets Not Found",Planets.class.getName(), planetsId);
        });
    }

    public void deleteById(String planetsId) {
        repo.deleteById(UUID.fromString(planetsId));
    }
}