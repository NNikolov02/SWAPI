package Web.Repository;

import Web.Model.Planets;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlanetsRepository extends CrudRepository<Planets, UUID> {

}