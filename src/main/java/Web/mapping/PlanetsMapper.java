package Web.mapping;


import Web.Model.Planets;
import Web.dto.PlanetsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlanetsMapper {


    PlanetsDto modelRoDto(Planets planets);

    Planets dtoModel(Planets planetsDto);
}
