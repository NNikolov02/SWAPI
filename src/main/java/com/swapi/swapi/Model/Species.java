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
public class Species {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("ID")
    private UUID id;

    private String url;
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
    //@OneToMany(mappedBy = "species")
    //private Set<Vehicle> vehicles;
    @ManyToMany(mappedBy = "species")
    private Set<Character> characters = new HashSet<>();
    @ManyToMany(mappedBy = "species")
    private Set<Film> films = new HashSet<>();
    @ManyToMany(mappedBy = "species")
    private Set<Planet> planets = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "species_starships", joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "starships_id"))
    @JsonIgnore
    private Set<Starship> starships;
    @ManyToMany
    @JoinTable(name = "species_vehicle", joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    @JsonIgnore
    private Set<Vehicle> vehicle;
    @JsonProperty("skin_colors")
    private String skincolors;



}
