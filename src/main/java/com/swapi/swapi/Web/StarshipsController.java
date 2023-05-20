package com.swapi.swapi.Web;

import com.swapi.swapi.Model.Starship;
import com.swapi.swapi.dto.character.CharacterResponse;
import com.swapi.swapi.dto.starships.StarshipsApiPage;
import com.swapi.swapi.dto.starships.StarshipsCreateRequest;
import com.swapi.swapi.dto.starships.StarshipsResponse;
import com.swapi.swapi.error.InvalidObjectException;
import com.swapi.swapi.mapping.StarshipsMapper;
import com.swapi.swapi.service.StarshipsService;
import com.swapi.swapi.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/starships")
@AllArgsConstructor
public class StarshipsController {

    @Autowired
    private ObjectValidator validator;
    @Autowired
    private StarshipsService starshipsService;
    @Autowired
    private StarshipsMapper starshipssMapper;
    private final Integer Page_Size = 10;


    @GetMapping(name = "", produces = "application/json")
    public StarshipsApiPage<StarshipsResponse> getAllStarships(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<StarshipsResponse> starshipsPage =
                starshipsService.fetchAll(currPage, Page_Size).map(starshipssMapper::responseFromModel);
        return new StarshipsApiPage<>(starshipsPage);


    }


    @GetMapping("/{starshipsId}")
    public ResponseEntity<StarshipsResponse> getStarshipsById(@PathVariable String starshipsId) {
        Starship starships = starshipsService.findById(starshipsId);
        StarshipsResponse responseStarships = starshipssMapper.responseFromModel(starships);
        responseStarships.getUrl();


        return ResponseEntity.ok(responseStarships);
    }

    @DeleteMapping("/{starshipsId}")
    public void deletestrashipsById(@PathVariable String starshipsId) {
        starshipsService.deleteById(starshipsId);
    }

    @PostMapping("")
    public ResponseEntity<StarshipsResponse> createStarships(@RequestBody StarshipsCreateRequest starshipsDto) {

        Map<String, String> validationErrors = validator.validate(starshipsDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Starship Create", validationErrors);
        }


        Starship mappedStarships = starshipssMapper.modelFromCreateRequest(starshipsDto);

        Starship savedStarships = starshipsService.save(mappedStarships);

        StarshipsResponse responseStarships = starshipssMapper.responseFromModel(savedStarships);

        return ResponseEntity.status(201).body(responseStarships);

    }
}