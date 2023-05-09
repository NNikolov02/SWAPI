package com.swapi.swapi.service;

import com.swapi.swapi.Model.Film;
import com.swapi.swapi.Repository.FilmPagingRepository;
import com.swapi.swapi.Repository.FilmRepository;
import com.swapi.swapi.error.NotFoundObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class FilmService {
    @Autowired
    private FilmRepository repo;

    @Autowired
    private FilmPagingRepository pagingRepo;

    public Film save(Film film) {

        return repo.save(film);
    }

    public Page<Film> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Film findById(String filmId) {
        return repo.findById(UUID.fromString(filmId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Film Not Found", Film.class.getName(), filmId);
        });
    }

    public void deleteById(String filmId) {
        repo.deleteById(UUID.fromString(filmId));
    }
}
