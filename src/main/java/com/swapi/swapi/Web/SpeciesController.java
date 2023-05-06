package com.swapi.swapi.Web;


import com.swapi.swapi.Web.Model.Planets;
import com.swapi.swapi.Web.Model.Species;
import com.swapi.swapi.Web.dto.planets.PlanetsApiPage;
import com.swapi.swapi.Web.dto.planets.PlanetsCreateRequest;
import com.swapi.swapi.Web.dto.planets.PlanetsResponse;
import com.swapi.swapi.Web.dto.species.SpeciesApiPage;
import com.swapi.swapi.Web.dto.species.SpeciesCreateRequest;
import com.swapi.swapi.Web.dto.species.SpeciesResponse;
import com.swapi.swapi.Web.error.InvalidObjectException;
import com.swapi.swapi.Web.mapping.PlanetsMapper;
import com.swapi.swapi.Web.mapping.SpeciesMapper;
import com.swapi.swapi.Web.service.PlanetsService;
import com.swapi.swapi.Web.service.SpeciesService;
import com.swapi.swapi.Web.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/species")
@AllArgsConstructor
public class SpeciesController {

    @Autowired
    private ObjectValidator validator;
    @Autowired
    private SpeciesService speciesService;
    @Autowired
    private SpeciesMapper speciesMapper;
    private final Integer Page_Size = 10;


    @GetMapping(name = "", produces = "application/json")
    public SpeciesApiPage<SpeciesResponse> getAllSpecies(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<SpeciesResponse> speciesPage =
                speciesService.fetchAll(currPage, Page_Size).map(speciesMapper::responseFromModel);
        return new SpeciesApiPage<>(speciesPage);


    }


    @GetMapping("/{speciesId}")
    public ResponseEntity<SpeciesResponse> getSpeciesById(@PathVariable String speciesId) {
        Species species = speciesService.findById(speciesId);

        return ResponseEntity.ok(speciesMapper.responseFromModel(species));
    }

    @DeleteMapping("/{speciesId}")
    public void deletespeciesById(@PathVariable String speciesId) {
        speciesService.deleteById(speciesId);
    }

    @PostMapping("")
    public ResponseEntity<SpeciesResponse> createSpecies(@RequestBody SpeciesCreateRequest speciesDto) {

        Map<String, String> validationErrors = validator.validate(speciesDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Species Create", validationErrors);
        }


        Species mappedSpecies = speciesMapper.modelFromCreateRequest(speciesDto);

        Species savedSpecies = speciesService.save(mappedSpecies);

        SpeciesResponse responseSpecies = speciesMapper.responseFromModel(savedSpecies);

        return ResponseEntity.status(201).body(responseSpecies);

    }
}