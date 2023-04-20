package Web.dto;

import Web.Model.Film;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class VehicleDto {
    private UUID id;

    private String name;

    @JsonProperty("cargo_capacity")
    private String cargocapacity;
    private String consumables;
    @JsonProperty("cost_in_credits")
    private String costincredits;
    private String created;
    private String crew;
    private String edited;
    private String length;
    private String manufacturer;
    @JsonProperty("max_atmosphering_speed")
    private String max_tmospheringspeed;
    private String model;

    private String passengers;



    @JsonProperty("vehicle_class")
    private String vehicleclass;
}
