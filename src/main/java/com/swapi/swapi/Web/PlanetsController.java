package com.swapi.swapi.Web;


import com.swapi.swapi.Model.Film;
import com.swapi.swapi.Model.Planet;

import com.swapi.swapi.dto.film.FilmResponse;
import com.swapi.swapi.dto.planets.PlanetsApiPage;
import com.swapi.swapi.dto.planets.PlanetsCreateRequest;
import com.swapi.swapi.dto.planets.PlanetsResponse;
import com.swapi.swapi.error.InvalidObjectException;
import com.swapi.swapi.mapping.PlanetsMapper;
import com.swapi.swapi.service.PlanetsService;
import com.swapi.swapi.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/planets")
@AllArgsConstructor
public class PlanetsController {

    @Autowired
    private ObjectValidator validator;
    @Autowired
    private PlanetsService planetsService;
    @Autowired
    private PlanetsMapper planetsMapper;
    private final Integer Page_Size = 10;


    @GetMapping(name = "", produces = "application/json")
    public PlanetsApiPage<PlanetsResponse> getAllPlanets(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<PlanetsResponse> planetsPage =
                planetsService.fetchAll(currPage, Page_Size).map(planetsMapper::responseFromModel);
        return new PlanetsApiPage<>(planetsPage);


    }


    @GetMapping("/{planetId}")
    public ResponseEntity<PlanetsResponse> getFilmById(@PathVariable String planetsId) {
        Planet planet = planetsService.findById(planetsId);

        return ResponseEntity.ok(planetsMapper.responseFromModel(planet));
    }

    @DeleteMapping("/{planetsId}")
    public void deleteplanetsById(@PathVariable String planetsId) {
        planetsService.deleteById(planetsId);
    }

    @PostMapping("")
    public ResponseEntity<PlanetsResponse> createPlanet(@RequestBody PlanetsCreateRequest planetsDto) {

        Map<String, String> validationErrors = validator.validate(planetsDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Planet Create", validationErrors);
        }


        Planet mappedPlanets = planetsMapper.modelFromCreateRequest(planetsDto);

        Planet savedPlanets = planetsService.save(mappedPlanets);

        PlanetsResponse responsePlanets = planetsMapper.responseFromModel(savedPlanets);

        return ResponseEntity.status(201).body(responsePlanets);

    }
}