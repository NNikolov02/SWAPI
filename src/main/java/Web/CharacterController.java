package Web;


import Web.Model.Character;
import Web.Repository.CharacterRepository;
import Web.dto.CharacterResponse;
import Web.mapping.CharacterMapper;
import Web.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/characters")
@AllArgsConstructor
public class CharacterController {

    @Autowired
    private CharacterRepository repo;

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


}
