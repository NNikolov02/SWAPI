package com.swapi.swapi.Web;


import com.swapi.swapi.Model.Species;
import com.swapi.swapi.dto.character.CharacterResponse;
import com.swapi.swapi.dto.species.SpeciesApiPage;
import com.swapi.swapi.dto.species.SpeciesCreateRequest;
import com.swapi.swapi.dto.species.SpeciesResponse;
import com.swapi.swapi.error.InvalidObjectException;
import com.swapi.swapi.mapping.SpeciesMapper;
import com.swapi.swapi.service.SpeciesService;
import com.swapi.swapi.validation.ObjectValidator;
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

        SpeciesResponse responseSpecies = speciesMapper.responseFromModel(species);
        responseSpecies.getUrl();


        return ResponseEntity.ok(responseSpecies);
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