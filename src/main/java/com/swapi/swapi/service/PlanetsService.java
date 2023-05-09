package com.swapi.swapi.service;

import com.swapi.swapi.Model.Film;
import com.swapi.swapi.Model.Planet;
import com.swapi.swapi.Repository.PlanetsPagingRepository;
import com.swapi.swapi.Repository.PlanetsRepository;
import com.swapi.swapi.error.NotFoundObjectException;
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

    public Planet save(Planet planets) {

        return repo.save(planets);
    }

    public Page<Planet> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Planet findById(String planetsId) {
        return repo.findById(UUID.fromString(planetsId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Planet Not Found", Planet.class.getName(), planetsId);
        });
    }

    public UUID generateIdFromUrl(String url) {
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        String[] segments = url.split("/");
        String lastSegment = segments[segments.length - 1];
        return UUID.nameUUIDFromBytes(lastSegment.getBytes());
    }


    public void deleteById(String planetsId) {
        repo.deleteById(UUID.fromString(planetsId));
    }
}