package Web.mapping;

import Web.Model.Film;
import Web.Model.Planets;
import Web.dto.FilmDto;
import Web.dto.PlanetsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FilmMapper {


    FilmDto modelRoDto(Film film);

    Film dtoModel(Film filmDto);
}
