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

@Mapper(uses = {FilmMapper.class, PlanetsMapper.class, SpeciesMapper.class,StarshipsMapper.class,VehicleMapper.class})
public interface CharacterMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "characterFilm", ignore = true)
    @Mapping(target = "characterVehicle", ignore = true)
    @Mapping(target = "characterStarships", ignore = true)
    @Mapping(target = "characterPlanets", ignore = true)
    Character modelFromCreateRequest(CharacterCreateRequest characterCreateDto);

    CharacterResponse responseFromModel(Character character);
    @Mapping(target = "characterFilm", ignore = true)
    @Mapping(target = "characterVehicle", ignore = true)
    @Mapping(target = "characterStarships", ignore = true)
    @Mapping(target = "characterPlanets", ignore = true)
    @Mapping(target = "gender",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "birthYear", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "mass", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "height", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(CharacterUpdateRequest personUpdateDto, @MappingTarget Character character);
    List<CharacterResponse> listOfModelToListOfDto(List<Character>character);

    List<CharacterResponse> listOfModelToListOfDto(Iterable<Character> all);
}
