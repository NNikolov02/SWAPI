package Web.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("ID")
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
    //private List<String> pilots;
    @JsonProperty("film")
    @ManyToOne
    private Film film;

    @JsonProperty("vehicle_class")
    private String vehicleclass;

}
