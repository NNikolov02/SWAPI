package Web.Repository;

import Web.Model.Starships;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StarshipsRepository extends CrudRepository<Starships, UUID> {

}
