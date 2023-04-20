package Web.dto;

import Web.Model.Character;
import Web.Model.Vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
@Data
@Builder
public class SpeciesDto {
    @JsonProperty("average_height")
    private String averageheight;
    @JsonProperty("average_lifespan")
    private String averagelifespan;
    private String classification;
    private String created;
    private String designation;
    private String edited;
    @JsonProperty("eye_colors")
    private String eyecolors;
    @JsonProperty("hair_colors")
    private String haircolors;
    private String homeworld;
    private String language;
    private String name;

    @JsonProperty("skin_colors")
    private String skincolors;
}
