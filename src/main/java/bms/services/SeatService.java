package bms.services;

import java.sql.SQLException;
import java.util.List;
import bms.DAOs.SeatDao;
import bms.dtos.SeatDto;
import jakarta.inject.Inject;

public class SeatService {
    @Inject
    SeatDao seatDao;

    public List<SeatDto> getAvailableSeatByShowTimeId(int show_time_id) throws SQLException {
        return seatDao.getAvailableSeatByShowTimeId(show_time_id);
    }

}
