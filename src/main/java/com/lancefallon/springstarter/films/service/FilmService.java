package com.lancefallon.springstarter.films.service;

import com.lancefallon.springstarter.films.model.Film;
import com.lancefallon.springstarter.films.repository.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private static final Logger logger = LoggerFactory.getLogger(FilmService.class);

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film findById(Integer id) {
        return filmRepository.findById(id);
    }

    public Integer addFilm(Film film) {
        return filmRepository.addFilm(film);
    }

    public Map<Integer, String> getFilmsMap() {
        logger.info("##LOGGER=> loading films map");
        return filmRepository.findAll().stream()
                .collect(Collectors.toMap(u -> u.getId(), u -> u.getTitle()));
    }
}
