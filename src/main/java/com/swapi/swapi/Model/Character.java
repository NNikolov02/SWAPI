package com.swapi.swapi.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swapi.swapi.validation.ValidGender;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;


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

    private String url;

    @JsonProperty("name")
    private String name;
    @ValidGender(message = "Character should be male or female!")
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
    @Range(min = 0, max = 300, message = "i like mass from 0 to 300")
    @JsonProperty("mass")
    private int mass;
    @JsonProperty("birth_year")
    private String birthYear;



    @ManyToMany
    @JoinTable(name = "character_films", joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "films_id"))
    @JsonIgnore
    private Set<Film> films;


    @ManyToMany
    @JoinTable(name = "character_planets", joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "planets_id"))
    @JsonIgnore
    private Set<Planet> planets;

    @ManyToMany
    @JoinTable(name = "character_species", joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "species_id"))
    @JsonIgnore
    private Set<Species> species;
    @ManyToMany
    @JoinTable(name = "character_starships", joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "starships_id"))
    @JsonIgnore
    private Set<Starship> starships;
    @ManyToMany
    @JoinTable(name = "character_vehicle", joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    @JsonIgnore
    private Set<Vehicle> vehicle;








    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    //@JsonIgnoreProperties("character")
    //private Vehicle vehicle;


    //@JsonIgnore
    //@ManyToMany(fetch =FetchType.EAGER,mappedBy = "StarshipsCharacter")
    //@JoinTable(name = "character_starships", joinColumns = @JoinColumn(name = "character_id"),
           /// inverseJoinColumns = @JoinColumn(name = "starships_id"))
    //private Set<Starships> characterStarships = new HashSet<>();



}
