package bms.DAOs;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import bms.config.PropertiesConfiguration;
import bms.dtos.MovieDto;
import bms.exceptions.UserExistException;
import bms.models.MovieModel;
import bms.models.UserModel;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class MovieDao {
    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getPostgreConnection() throws SQLException {
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionUrl(),
                propertiesConfiguration.getDbUsername(),
                propertiesConfiguration.getDbPassword());
    }

    public List<MovieDto> getMovieByCityId(int city_id) throws SQLException {
        Connection con = getPostgreConnection();
        String FETCH_USER_EMAIL = "Select m.id,m.name,m.description ,m.release_date from movie as m INNER JOIN movie_city as mc on m.id=mc.movie_id WHERE city_id=?";
        PreparedStatement stmt = con.prepareStatement(FETCH_USER_EMAIL);

        stmt.setInt(1, city_id);

        ResultSet rst = stmt.executeQuery();

        return getMovieDto(rst);

    }

    private List<MovieDto> getMovieDto(ResultSet rst) throws SQLException {
        List<MovieDto> listOfMovie = new ArrayList<>();
        while (rst.next()) {
            MovieDto movieDto = new MovieDto();
            movieDto.setDescription(rst.getString("description"));
            movieDto.setId(rst.getInt("id"));
            movieDto.setRelease_date(rst.getTimestamp("release_date"));
            movieDto.setName(rst.getString("name"));
            listOfMovie.add(movieDto);
        }
        return listOfMovie;
    }

}
