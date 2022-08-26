package bms.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bms.config.PropertiesConfiguration;
import bms.dtos.SeatDto;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SeatDao {
    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getPostgreConnection() throws SQLException {
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionUrl(),
                propertiesConfiguration.getDbUsername(),
                propertiesConfiguration.getDbPassword());
    }

    public List<SeatDto> getAvailableSeatByShowTimeId(int show_time_id) throws SQLException {
        Connection con = getPostgreConnection();
        String FETCH_AVAILABLE_SEAT = "Select s.id,s.seat_no from seat as s INNER JOIN cinema_screen as cs on s.cinema_screen_id =cs.id INNER JOIN show_time as st on st.cinema_screen_id=cs.id WHERE st.id=? "
                +
                "and s.id NOT IN (Select s.id from seat as s INNER JOIN booking as b on b.seat_id=s.id where b.show_time_id=?)";
        PreparedStatement stmt = con.prepareStatement(FETCH_AVAILABLE_SEAT);

        stmt.setInt(1, show_time_id);
        stmt.setInt(2, show_time_id);

        ResultSet rst = stmt.executeQuery();

        return getAvailableSeatDto(rst);

    }

    private List<SeatDto> getAvailableSeatDto(ResultSet rst) throws SQLException {

        List<SeatDto> listOfAvailableSeat = new ArrayList<>();
        while (rst.next()) {

            SeatDto seat = new SeatDto();
            seat.setId(rst.getInt("id"));
            seat.setSeat_no(rst.getString("seat_no"));

            listOfAvailableSeat.add(seat);
        }
        return listOfAvailableSeat;
    }

}
