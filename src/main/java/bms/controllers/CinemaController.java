
package bms.controllers;

import java.sql.SQLException;
import java.util.List;

import bms.dtos.CinemaDto;
import bms.dtos.SeatDto;
import bms.services.CinemaService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/movies")
public class CinemaController {
    @Inject
    CinemaService cinemaService;

    @Get("/{movie_id}/cinemas")
    @Operation(tags="GET")
    @ApiResponse(responseCode = "200",description = "success",content = @Content(mediaType = "application/json",schema = @Schema(implementation = CinemaDto.class)))
    @ApiResponse(responseCode = "500",description = "Sql Exception",content = @Content(mediaType = "application/json",schema = @Schema(implementation = String.class)))
    public List<CinemaDto> saveUser(int movie_id) throws SQLException {
        return cinemaService.getCinemaByMovieId(movie_id);

    }

}
