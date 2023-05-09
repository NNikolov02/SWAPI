package com.swapi.swapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Starship {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("ID")
    private UUID id;

    private String url;
    private String name;

    private String MGLT;
    @JsonProperty("cargo_capacity")
    private String cargocapacity;


    private String consumables;

    @JsonProperty("cost_in_credits")
    private Long costincredits;

    private String created;
    private  Long crew;
    private String edited;
    @JsonProperty("hyperdrive_rating")
    private Float hyperdriverating;
    private Long length;
    private String manufacturer;

    @JsonProperty("max_atmosphering_speed")
    private String maxatmospheringspeed;
    private String model;
    private Long passengers;
    //@JsonProperty("film")
    //@ManyToOne
    //private Film film;

    //@JsonProperty("starship_class")
   // private String starshipclass;

    @ManyToMany(mappedBy = "starships")
    private Set<Character> characters = new HashSet<>();
    @ManyToMany(mappedBy = "starships")
    private Set<Film> films = new HashSet<>();
    @ManyToMany(mappedBy = "starships")
    private Set<Planet> planets = new HashSet<>();
    @ManyToMany(mappedBy = "starships")
    private Set<Species> species = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "starships_vehicle", joinColumns = @JoinColumn(name = "starships_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    @JsonIgnore
    private Set<Vehicle> vehicle;




}
