package Web;


import Web.Repository.CharacterRepository;
import Web.dto.CharacterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository repo;

    @GetMapping("/{characterId}")
    public ResponseEntity<CharacterResponse> getCharacterById(@PathVariable String characterId) {


}
