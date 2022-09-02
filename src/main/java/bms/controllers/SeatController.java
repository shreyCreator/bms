
package bms.controllers;

import java.sql.SQLException;
import java.util.List;

import bms.dtos.BookingResponseDto;
import bms.dtos.SeatDto;
import bms.services.SeatService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/showtime")
public class SeatController {
    @Inject
    SeatService seatService;

    @Get("/{show_time_id}/seats")
    @Operation(tags="GET")
    @ApiResponse(responseCode = "200",description = "success",content = @Content(mediaType = "application/json",schema = @Schema(implementation = SeatDto.class)))
    @ApiResponse(responseCode = "500",description = "Sql Exception",content = @Content(mediaType = "application/json",schema = @Schema(implementation = String.class)))
    public List<SeatDto> getAvailableSeatByShowTimeId(int show_time_id) throws SQLException {
        return seatService.getAvailableSeatByShowTimeId(show_time_id);

    }

}
