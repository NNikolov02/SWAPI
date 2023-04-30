package com.swapi.swapi.Web.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;


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



    @ManyToMany
    @JoinTable(name = "character_film", joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    @JsonIgnore
    private Set<Film> films;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "planets_id", referencedColumnName = "id")
    @JsonIgnoreProperties("character")
    private Planets planets;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    @JsonIgnoreProperties("character")
    private Species species;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "starships_id", referencedColumnName = "id")
    @JsonIgnoreProperties("character")
    private Starships starships;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @JsonIgnoreProperties("character")
    private Vehicle vehicle;


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
