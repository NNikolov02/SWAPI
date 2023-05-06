package com.swapi.swapi.Web;

import com.swapi.swapi.Web.Model.Film;
import com.swapi.swapi.Web.dto.film.FilmApiPage;
import com.swapi.swapi.Web.dto.film.FilmCreateRequest;
import com.swapi.swapi.Web.dto.film.FilmResponse;
import com.swapi.swapi.Web.error.InvalidObjectException;
import com.swapi.swapi.Web.mapping.FilmMapper;
import com.swapi.swapi.Web.service.FilmService;
import com.swapi.swapi.Web.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

    @Autowired
    private ObjectValidator validator;
    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmMapper filmMapper;
    private final Integer Page_Size = 10;


    @GetMapping(name = "",produces = "application/json")
    public FilmApiPage<FilmResponse> getAllFilm(

            @RequestParam(required = false,defaultValue = "0") Integer currPage){
        Page<FilmResponse> filmPage =
                filmService.fetchAll(currPage, Page_Size).map(filmMapper::responseFromModel);
        return new FilmApiPage<>(filmPage);


    }


    @GetMapping("/{filmId}")
    public ResponseEntity<FilmResponse> getFilmById(@PathVariable String filmId) {
        Film film = filmService.findById(filmId);

        return ResponseEntity.ok(filmMapper.responseFromModel(film));
    }
    @DeleteMapping("/{filmId}")
    public void deletefilmById(@PathVariable String filmId) {
        filmService.deleteById(filmId);
    }
    @PostMapping("")
    public ResponseEntity<FilmResponse> createFilm(@RequestBody FilmCreateRequest filmDto) {

        Map<String, String> validationErrors = validator.validate(filmDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Film Create", validationErrors);
        }


        Film mappedFilm = filmMapper.modelFromCreateRequest(filmDto);

        Film savedFilm = filmService.save(mappedFilm);

        FilmResponse responseFilm = filmMapper.responseFromModel(savedFilm);

        return ResponseEntity.status(201).body(responseFilm);

    }

}