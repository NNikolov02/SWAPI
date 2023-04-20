package Web.mapping;

import Web.Model.Character;
import Web.dto.CharacterCreateRequest;
import Web.dto.CharacterResponse;
import Web.dto.CharacterUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(uses = FilmMapper.class)
public interface CharacterMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "photos", ignore = true)
    Character modelFromCreateRequest(CharacterCreateRequest characterCreateDto);

    CharacterResponse responseFromModel(Character character);

    @Mapping(target = "photos", ignore = true)
    @Mapping(target = "egnNumber", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "age", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "address", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(CharacterUpdateRequest personUpdateDto, @MappingTarget Character character);
    List<CharacterResponse> listOfModelToListOfDto(List<Character>character);

    List<CharacterResponse> listOfModelToListOfDto(Iterable<Character> all);
}
