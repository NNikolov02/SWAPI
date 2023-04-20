package Web.dto;

import Web.Model.Film;
import Web.Model.Planets;
import Web.Model.Starships;
import Web.Model.Vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CharacterResponse {
    @JsonProperty("ID")
    private UUID id;


    private String name;

    private String gender;

    private SpeciesDto species;

    private int height;

    private int mass;
    @JsonProperty("birth_year")
    private String birthYear;


    private FilmDto film;


    private StarshipsDto starships;


    private PlanetsDto planets;


    private VehicleDto vehicle;
}
