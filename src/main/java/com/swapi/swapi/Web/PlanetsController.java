package com.swapi.swapi.Web;


import com.swapi.swapi.Web.Model.Planets;

import com.swapi.swapi.Web.dto.planets.PlanetsApiPage;
import com.swapi.swapi.Web.dto.planets.PlanetsCreateRequest;
import com.swapi.swapi.Web.dto.planets.PlanetsResponse;
import com.swapi.swapi.Web.error.InvalidObjectException;
import com.swapi.swapi.Web.mapping.PlanetsMapperC;
import com.swapi.swapi.Web.service.PlanetsService;
import com.swapi.swapi.Web.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/planets")
@AllArgsConstructor
public class PlanetsController {

    @Autowired
    private ObjectValidator validator;
    @Autowired
    private PlanetsService planetsService;
    @Autowired
    private PlanetsMapperC planetsMapper;
    private final Integer Page_Size = 10;


    @GetMapping(name = "", produces = "application/json")
    public PlanetsApiPage<PlanetsResponse> getAllPlanets(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<PlanetsResponse> planetsPage =
                planetsService.fetchAll(currPage, Page_Size).map(planetsMapper::responseFromModel);
        return new PlanetsApiPage<>(planetsPage);


    }


    @GetMapping("/{planetsId}")
    public ResponseEntity<PlanetsResponse> getPlanetsById(@PathVariable String planetsId) {
        Planets planets = planetsService.findById(planetsId);

        return ResponseEntity.ok(planetsMapper.responseFromModel(planets));
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


        Planets mappedPlanets = planetsMapper.modelFromCreateRequest(planetsDto);

        Planets savedPlanets = planetsService.save(mappedPlanets);

        PlanetsResponse responsePlanets = planetsMapper.responseFromModel(savedPlanets);

        return ResponseEntity.status(201).body(responsePlanets);

    }
}