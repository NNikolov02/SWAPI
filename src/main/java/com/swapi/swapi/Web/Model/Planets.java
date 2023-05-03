package com.swapi.swapi.Web.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Planets {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("ID")
    private UUID id;

    private String url;

    private String climate;
    private String created;
    private String diameter;
    private String edited;
   // @JsonProperty("film")
   // @ManyToOne
    //private Film film;
    private String gravity;
    private String name;
    @JsonProperty("orbital_period")
    private String orbitalperiod;
    private String population;
    //private List<String> residents;
    @JsonProperty("rotation_period")
    private String rotation_period;
    @JsonProperty("surface_water")
    private String surface_water;
    private String terrain;

    @ManyToMany(mappedBy = "planets")
    private Set<Character> characters;
    @ManyToMany(mappedBy = "planets")
    private Set<Film> films;
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



}
