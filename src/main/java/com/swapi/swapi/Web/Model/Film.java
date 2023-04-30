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
public class Film {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @JsonProperty("id")
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
    @ManyToMany(mappedBy = "films")
    private Set<Character> characters;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "planets_id", referencedColumnName = "id")
    @JsonIgnoreProperties("film")
    private Planets planets;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    @JsonIgnoreProperties("film")
    private Species species;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "starships_id", referencedColumnName = "id")
    @JsonIgnoreProperties("film")
    private Starships starships;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @JsonIgnoreProperties("film")
    private Vehicle vehicle;




    // @OneToMany(mappedBy = "film")
   // private Set<Starships> starships;



   // @OneToMany(mappedBy = "film")
    //private Set<Vehicle> vehicles;




}
