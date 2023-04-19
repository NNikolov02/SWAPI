package Web.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.mapping.List;


import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("ID")
    private UUID id;
    private String title;

    private String created;
    private String director;
    private String edited;
    @JsonProperty("episode_id")
    private int episodeId;
    @JsonProperty("opening_crawl")
    private String openingcrawl;
    //private List<String> planets;
    private String producer;
    @JsonProperty("release_date")
    private String releasedate;
    //private List<String> species;

    @OneToMany(mappedBy = "film")
    private Set<Starships> starships;



    @OneToMany(mappedBy = "film")
    private Set<Vehicle> vehicles;
    @OneToMany(mappedBy = "film")
    private Set<Character> characters;



}
