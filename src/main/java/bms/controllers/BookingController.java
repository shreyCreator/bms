
package bms.controllers;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import bms.dtos.BookingResponseDto;
import bms.dtos.CinemaDto;
import bms.dtos.SeatDto;
import bms.services.BookingService;
import bms.services.CinemaService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/v1/showtimes")
@SecurityRequirement(name = "bms")
public class BookingController {
    @Inject
    BookingService bookingService;

    @Get("/{show_time_id}/seats/{seat_id}")
    @Operation(tags="POST")
    @ApiResponse(responseCode = "200",description = "success",content = @Content(mediaType = "application/json",schema = @Schema(implementation = BookingResponseDto.class)))
    @ApiResponse(responseCode = "500",description = "Sql Exception",content = @Content(mediaType = "application/json",schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "401",description = "Unauthorsied")
    @ApiResponse(responseCode = "403",description = "Forbidden")
    public BookingResponseDto saveUser(int show_time_id,int seat_id,@Header("Authorization") String authorizationHeader) throws SQLException {

    return bookingService.bookSeat(show_time_id,seat_id,authorizationHeader);
    }


}
