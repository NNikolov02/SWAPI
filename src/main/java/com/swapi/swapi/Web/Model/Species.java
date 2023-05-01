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
    @OneToOne(mappedBy = "species")
    @JsonIgnoreProperties("species")
    private Character character;
    @JsonProperty("skin_colors")
    private String skincolors;

    @OneToOne(mappedBy = "species")
    @JsonIgnoreProperties("species")
    private Film film;

}
