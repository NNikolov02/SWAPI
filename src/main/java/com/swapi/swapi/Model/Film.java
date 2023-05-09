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
public class Film {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("id")
    private UUID id;
    private String title;

    private String url;

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
    @ManyToMany(mappedBy = "films")
    private Set<Character> characters = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "films_planets", joinColumns = @JoinColumn(name = "films_id"),
            inverseJoinColumns = @JoinColumn(name = "planets_id"))
    @JsonIgnore
    private Set<Planet> planets;


    @ManyToMany
    @JoinTable(name = "films_species", joinColumns = @JoinColumn(name = "films_id"),
            inverseJoinColumns = @JoinColumn(name = "species_id"))
    @JsonIgnore
    private Set<Species> species;

    @ManyToMany
    @JoinTable(name = "films_starships", joinColumns = @JoinColumn(name = "films_id"),
            inverseJoinColumns = @JoinColumn(name = "starships_id"))
    @JsonIgnore
    private Set<Starship> starships;
    @ManyToMany
    @JoinTable(name = "films_vehicle", joinColumns = @JoinColumn(name = "films_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    @JsonIgnore
    private Set<Vehicle> vehicle;




    // @OneToMany(mappedBy = "film")
   // private Set<Starships> starships;



   // @OneToMany(mappedBy = "film")
    //private Set<Vehicle> vehicles;




}
