package bms.DAOs;

import bms.config.PropertiesConfiguration;
import bms.dtos.CinemaDto;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.*;
import java.util.List;
//import java.util.List;
@Singleton
public class BookingDao {
    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getPostgreConnection() throws SQLException {
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionUrl(),
                propertiesConfiguration.getDbUsername(),
                propertiesConfiguration.getDbPassword());
    }

    public void bookSeat(int user_id,int show_time_id,int seat_id) throws SQLException {
        Connection con=getPostgreConnection();
        String BOOK_SEAT_WITH_SHOWTIME="Insert into booking (user_id,show_time_id,seat_id) VALUES (?,?,?) ";
        PreparedStatement stmt=con.prepareStatement(BOOK_SEAT_WITH_SHOWTIME);
        stmt.setInt(1,user_id);
        stmt.setInt(2,show_time_id);
        stmt.setInt(3,seat_id);
        stmt.executeUpdate();
        stmt.close();
        con.close();


    }
}
