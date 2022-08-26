package bms.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bms.config.PropertiesConfiguration;
import bms.dtos.CinemaDto;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CinemaDao {
    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getPostgreConnection() throws SQLException {
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionUrl(),
                propertiesConfiguration.getDbUsername(),
                propertiesConfiguration.getDbPassword());
    }

    public List<CinemaDto> getCinemaByMovieId(int movie_id) throws SQLException {
        Connection con = getPostgreConnection();
        String FETCH_CINEMA_WITH_SHOWTIME = "Select s.id as showtime_id, s.start_time, s.end_time, " +
                "m.name as movie_name, c.name as cinema_name, c.id as cinema_id " +
                "From show_time as s " +
                "INNER JOIN movie as m ON m.id = s.movie_id " +
                "INNER JOIN cinema_screen as sc ON s.cinema_screen_id = sc.id " +
                "INNER JOIN cinema as c ON sc.cinema_id = c.id " +
                "WHERE s.movie_id = ?";

        PreparedStatement stmt = con.prepareStatement(FETCH_CINEMA_WITH_SHOWTIME);
        stmt.setInt(1, movie_id);
        ResultSet rst = stmt.executeQuery();

        return getListOfCinemaDto(rst);

    }

    private List<CinemaDto> getListOfCinemaDto(ResultSet rst) throws SQLException {

        List<CinemaDto> listOfCinemaWithShowTime = new ArrayList<>();
        while (rst.next()) {

            CinemaDto cinema = new CinemaDto();
            cinema.setCinema_name(rst.getString("cinema_name"));
            cinema.setMovie_name(rst.getString("movie_name"));
            cinema.setEnd_time(rst.getString("end_time"));
            cinema.setStart_time(rst.getString("start_time"));
            cinema.setShowtime_id(rst.getInt("showtime_id"));

            listOfCinemaWithShowTime.add(cinema);
        }
        return listOfCinemaWithShowTime;
    }

}
