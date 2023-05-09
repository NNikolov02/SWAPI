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
public class Planet {

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
    public static UUID generateIdFromUrl(String url) {
        // remove trailing slash if present
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        // get the last segment of the URL
        String[] segments = url.split("/");
        String lastSegment = segments[segments.length - 1];
        // use the last segment to generate a UUID
        UUID uuid = UUID.nameUUIDFromBytes(lastSegment.getBytes());
        return uuid;
    }

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
    private Set<Starship> starships;
    @ManyToMany
    @JoinTable(name = "planets_vehicle", joinColumns = @JoinColumn(name = "planets_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    @JsonIgnore
    private Set<Vehicle> vehicle;



}
