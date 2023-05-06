package com.swapi.swapi.Web.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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

    @JsonIgnore
    @ManyToMany(mappedBy = "planets")
    private Set<Character> characters = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "planets")
    private Set<Film> films = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "planets_species", joinColumns = @JoinColumn(name = "planets_id"),
            inverseJoinColumns = @JoinColumn(name = "species_id"))
    @JsonIgnore
    private Set<Species> species;

    @ManyToMany
    @JoinTable(name = "planets_starships", joinColumns = @JoinColumn(name = "planets_id"),
            inverseJoinColumns = @JoinColumn(name = "starships_id"))
    @JsonIgnore
    private Set<Starships> starships;
    @ManyToMany
    @JoinTable(name = "planets_vehicle", joinColumns = @JoinColumn(name = "planets_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    @JsonIgnore
    private Set<Vehicle> vehicle;



}
