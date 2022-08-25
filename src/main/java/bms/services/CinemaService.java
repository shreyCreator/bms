package bms.services;

import java.sql.SQLException;
import java.util.List;

import bms.DAOs.CinemaDao;
import bms.dtos.CinemaDto;
import jakarta.inject.Inject;

public class CinemaService {
    @Inject
    CinemaDao cinemaDao;

    public List<CinemaDto> getCinemaByMovieId(int movie_id) throws SQLException {
        return cinemaDao.getCinemaByMovieId(movie_id);
    }

}
