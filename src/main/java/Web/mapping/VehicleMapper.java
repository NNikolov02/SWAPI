package Web.mapping;

import Web.Model.Starships;
import Web.Model.Vehicle;
import Web.dto.StarshipsDto;
import Web.dto.VehicleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {


    VehicleDto modelRoDto(Vehicle vehicle);

    Vehicle dtoModel(Vehicle vehicleDto);
}
