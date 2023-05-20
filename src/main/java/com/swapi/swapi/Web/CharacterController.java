package com.swapi.swapi.Web;

import com.swapi.swapi.dto.character.CharacterApiPage;
import com.swapi.swapi.error.InvalidObjectException;
import com.swapi.swapi.Model.Character;
import com.swapi.swapi.dto.character.CharacterCreateRequest;
import com.swapi.swapi.dto.character.CharacterResponse;
import com.swapi.swapi.mapping.CharacterMapper;

import com.swapi.swapi.service.CharacterService;
import com.swapi.swapi.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/characters")
@AllArgsConstructor

public class CharacterController {

    @Autowired
    private ObjectValidator validator;
    @Autowired
    private CharacterService characterService;
    @Autowired
    private CharacterMapper characterMapper;
    private final Integer Page_Size = 10;


    @GetMapping(name = "",produces = "application/json")

    public CharacterApiPage<CharacterResponse> getAllCharacters(

            @RequestParam(required = false,defaultValue = "0") Integer currPage){
        Page<CharacterResponse> characterPage =
                characterService.fetchAll(currPage, Page_Size).map(characterMapper::responseFromModel);
        return new CharacterApiPage<>(characterPage);


    }


    @GetMapping("/{characterId}")
    public ResponseEntity<CharacterResponse> getCharacterById(@PathVariable String characterId) {
       Character character = characterService.findById(characterId);


        CharacterResponse responseCharacter = characterMapper.responseFromModel(character);
        responseCharacter.getUrl();


        return ResponseEntity.ok(responseCharacter);
    }
    @DeleteMapping("/{characterId}")
    public void deleteCharacterById(@PathVariable String characterId) {
        characterService.deleteById(characterId);
    }
    @PostMapping("")
    public ResponseEntity<CharacterResponse> createCharacter(@RequestBody CharacterCreateRequest characterDto) {

        Map<String, String> validationErrors = validator.validate(characterDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Character Create", validationErrors);
        }


        Character mappedCharacter = characterMapper.modelFromCreateRequest(characterDto);

        Character savedCharacter = characterService.save(mappedCharacter);

        CharacterResponse responseCharacter = characterMapper.responseFromModel(savedCharacter);

        return ResponseEntity.status(201).body(responseCharacter);

    }


}
