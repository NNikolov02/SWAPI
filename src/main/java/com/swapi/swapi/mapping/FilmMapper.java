package com.swapi.swapi.mapping;

import com.swapi.swapi.Model.*;
import com.swapi.swapi.Model.Character;
import com.swapi.swapi.dto.film.FilmCreateRequest;
import com.swapi.swapi.dto.film.FilmResponse;
import com.swapi.swapi.dto.film.FilmUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Mapper(uses = {CharacterMapperDTO.class, PlanetsMapperDTO.class, SpeciesMapperDTO.class, StarshipsMapperDTO.class, VehicleMapperDTO.class})
public interface FilmMapper {
    public static Set<String> personUrlsFromFilm(Set<Character> persons){
        Set<String> personUrls = new HashSet<>();

        if(persons != null){
            for(Character person : persons){
                personUrls.add("http://localhost:8080/swapi/persons/" + person.getId());
            }
        }

        return personUrls;
    }

    public static Set<String> vehicleUrlsFromFilm(Set<Vehicle> vehicles){
        Set<String> vehicleUrls = new HashSet<>();

        if(vehicles != null){
            for(Vehicle vehicle : vehicles){
                vehicleUrls.add("http://localhost:8080/swapi/vehicles/" + vehicle.getId());
            }
        }

        return vehicleUrls;
    }

    public static Set<String> starshipUrlsFromFilm(Set<Starship> starships){
        Set<String> starshipUrls = new HashSet<>();

        if(starships!=null){
            for(Starship starship : starships){
                starshipUrls.add("http://localhost:8080/swapi/starships/" + starship.getId());
            }
        }

        return starshipUrls;
    }

    public static Set<String> specieUrlsFromFilm(Set<Species> species){
        Set<String> specieUrls = new HashSet<>();

        if(species != null){
            for(Species specie : species){
                specieUrls.add("http://localhost:8080/swapi/species/" + specie.getId());
            }
        }

        return specieUrls;
    }

    public static Set<String> planetUrlsFromFilm(Set<Planet> planets){
        Set<String> planetUrls = new HashSet<>();

        if (planets != null){
            for(Planet planet : planets){
                planetUrls.add("http://localhost:8080/swapi/planets/" + planet.getId());
            }
        }

        return planetUrls;
    }




    Film modelFromCreateRequest(FilmCreateRequest filmCreateDto);

    FilmResponse responseFromModel(Film film);

    void updateModelFromDto(FilmUpdateRequest filmUpdateDto, @MappingTarget Film film);
    List<FilmResponse> listOfModelToListOfDto(List<Film>film);

    List<FilmResponse> listOfModelToListOfDto(Iterable<Film> all);
}