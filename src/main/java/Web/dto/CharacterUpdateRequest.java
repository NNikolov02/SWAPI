package Web.dto;

import Web.validation.ValidGender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterUpdateRequest {
    private String name;

    @ValidGender(message = "Character should be male or female")
    private String gender;

    private SpeciesDto species;

    private int height;

    private int mass;
    @JsonProperty("birth_year")
    private String birthYear;


    private FilmDto characterFilm;


    private StarshipsDto characterStarships;


    private PlanetsDto characterPlanets;


    private VehicleDto characterVehicle;

}
