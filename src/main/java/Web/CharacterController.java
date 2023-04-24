package Web;

import Web.error.InvalidObjectException;
import Web.Model.Character;
import Web.Repository.CharacterRepository;
import Web.dto.CharacterCreateRequest;
import Web.dto.CharacterResponse;
import Web.mapping.CharacterMapper;
import Web.mapping.CharacterMapperImpl;
import Web.service.CharacterService;
import Web.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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





    @GetMapping("/{characterId}")
    public ResponseEntity<CharacterResponse> getCharacterById(@PathVariable String characterId) {
       Character character = characterService.findById(characterId);

        return ResponseEntity.ok(characterMapper.responseFromModel(character));
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
