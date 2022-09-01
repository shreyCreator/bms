package bms.services;

import bms.DAOs.BookingDao;
import bms.DAOs.SeatDao;
import bms.DAOs.UserModelDao;
import bms.dtos.BookingResponseDto;
import bms.dtos.SeatDto;
import bms.utils.Base64Decoder;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.micronaut.security.authentication.AuthenticationRequest;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@Singleton
public class BookingService {

    @Inject
    UserModelDao userModelDao;
    @Inject
    BookingDao bookingDao;
    @Inject
    SeatDao seatDao;

    public BookingResponseDto bookSeat(int show_time_id, int seat_id,String authHeader) throws SQLException
    {
        String email = getUserEmail(authHeader);
        int user_id=getUserId(email);
        if(isSeatAvailable(show_time_id,seat_id)) {
            bookingDao.bookSeat(user_id, show_time_id, seat_id);
            return   successBookingResponse(email,seat_id);
        }
        return  failureBookingResponse(email);
    }
    public BookingResponseDto successBookingResponse(String email,int seat_id) throws SQLException {
        BookingResponseDto bookingResponseDto=new BookingResponseDto();
        bookingResponseDto.setEmail(email);
        bookingResponseDto.setStatus("yay!! seat booked successfully");
        bookingResponseDto.setSeat_id(seat_id);
        return bookingResponseDto;

    }
    public BookingResponseDto failureBookingResponse(String email) throws SQLException {
        BookingResponseDto bookingResponseDto=new BookingResponseDto();
        bookingResponseDto.setEmail(email);
        bookingResponseDto.setStatus("Sorry seat is not availabe");
        return bookingResponseDto;

    }
    public boolean isSeatAvailable(int show_time_id,int seat_id) throws SQLException {
        List<SeatDto> seatDtoList=seatDao.getAvailableSeatByShowTimeId(show_time_id);
        for(SeatDto seat:seatDtoList)
        {
            if(seat.getId()==seat_id)
                return true;

        }
        return false;
    }
    public int getUserId(String email)
    {
        return userModelDao.getUserId(email);
    }
    private String getUserEmail(String authHeader) {
        String headerContent=authHeader.split(" ")[1];

        String decodedHeader = Base64Decoder.decode(headerContent);
        String[] userPass=decodedHeader.split(":");
        return  userPass[0];

    }
}
