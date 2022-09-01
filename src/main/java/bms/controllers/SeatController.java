
package bms.controllers;

import java.sql.SQLException;
import java.util.List;
import bms.dtos.SeatDto;
import bms.services.SeatService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/showtime")
public class SeatController {
    @Inject
    SeatService seatService;

    @Get("/{show_time_id}/seats")
    public List<SeatDto> saveUser(int show_time_id) throws SQLException {
        return seatService.getCinemaByMovieId(show_time_id);

    }

}
