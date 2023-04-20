package Web.mapping;

import Web.Model.Planets;
import Web.Model.Species;
import Web.dto.PlanetsDto;
import Web.dto.SpeciesDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpeciesMapper {


    SpeciesDto modelRoDto(Species species);

    Species dtoModel(Species speciesDto);
}