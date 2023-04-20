package Web.mapping;

import Web.Model.Species;
import Web.Model.Starships;
import Web.dto.SpeciesDto;
import Web.dto.StarshipsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StarshipsMapper {


    StarshipsDto modelRoDto(Starships starships);

    Starships dtoModel(Starships starshipsDto);
}