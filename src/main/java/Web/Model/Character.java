package Web.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.mapping.List;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Character {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("eye_color")
    private String eyecolor;
    @JsonProperty("hair_color")
    private String haircolor;
    @JsonProperty("skin_color")
    private String skincolor;

    @JsonProperty("height")
    private int height;
    @JsonProperty("mass")
    private int mass;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonIgnore
    @ManyToMany(fetch =FetchType.EAGER,mappedBy = "filmCharacter")
    private Set<Film> characterFilm = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch =FetchType.EAGER,mappedBy = "StarshipsCharacter")
    //@JoinTable(name = "character_starships", joinColumns = @JoinColumn(name = "character_id"),
           /// inverseJoinColumns = @JoinColumn(name = "starships_id"))
    private Set<Starships> characterStarships = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch =FetchType.EAGER,mappedBy = "planetsCharacter")
    private Set<Planets> characterPlanets = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch =FetchType.EAGER,mappedBy = "vehicleCharacter")
    private Set<Vehicle> characterVehicle = new HashSet<>();


}
