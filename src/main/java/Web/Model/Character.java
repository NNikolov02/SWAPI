package Web.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.mapping.List;

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
    @JsonProperty("ID")
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
    @JsonProperty("film")
    @ManyToOne
    private Film film;

    @ManyToOne
    private Starships starships;

    @ManyToOne
    private Vehicle vehicle;


}
