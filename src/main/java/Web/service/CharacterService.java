package Web.service;

import Web.Model.Character;
import Web.Repository.CharacterPagingRepository;
import Web.Repository.CharacterRepository;
import Web.error.NotFoundObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository repo;

    @Autowired
    private CharacterPagingRepository pagingRepo;



    public Character save(Character character) {

        return repo.save(character);
    }


    public Character findById(String characterId) {
        return repo.findById(UUID.fromString(characterId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Character Not Found", Character.class.getName(), characterId);
        });
    }
    public void deleteById(String characterId) {

        repo.deleteById(UUID.fromString(characterId));
    }



}
