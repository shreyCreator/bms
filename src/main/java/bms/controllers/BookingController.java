
package bms.controllers;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import bms.dtos.BookingResponseDto;
import bms.dtos.CinemaDto;
import bms.services.BookingService;
import bms.services.CinemaService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/v1/showtimes")
public class BookingController {
    @Inject
    BookingService bookingService;

    @Get("/{show_time_id}/seats/{seat_id}")
    public BookingResponseDto saveUser(int show_time_id,int seat_id,@Header("Authorization") String authorizationHeader) throws SQLException {

    return bookingService.bookSeat(show_time_id,seat_id,authorizationHeader);
    }


}
