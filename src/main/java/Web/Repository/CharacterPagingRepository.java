package Web.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;


public interface CharacterPagingRepository extends PagingAndSortingRepository<Character, UUID> {

}
