package bms.services;

import java.sql.SQLException;
import java.util.List;

import bms.DAOs.MovieDao;
import bms.dtos.MovieDto;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class MovieService {

    @Inject
    MovieDao movieDao;

    public List<MovieDto> getMovieByCityId(int city_id) throws SQLException {
        return movieDao.getMovieByCityId(city_id);

    }

}
