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
public class Starships {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("ID")
    private UUID id;
    private String name;

    private String MGLT;
    @JsonProperty("cargo_capacity")
    private String cargocapacity;


    private String consumables;

    @JsonProperty("cost_in_credits")
    private Long costincredits;

    private String created;
    private  Long crew;
    private String edited;
    @JsonProperty("hyperdrive_rating")
    private Float hyperdriverating;
    private Long length;
    private String manufacturer;

    @JsonProperty("max_atmosphering_speed")
    private String maxatmospheringspeed;
    private String model;
    private Long passengers;
    @JsonProperty("film")
    @ManyToOne
    private Film film;
    @JsonProperty("starship_class")
    private String starshipclass;



}
