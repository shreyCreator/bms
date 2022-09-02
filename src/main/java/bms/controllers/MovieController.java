package bms.controllers;

import java.sql.SQLException;
import java.util.List;

import bms.Application;
import bms.dtos.MovieDto;
import bms.dtos.SeatDto;
import bms.services.MovieService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.inject.Inject;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/cities")
public class MovieController {

    @Inject
    MovieService movieService;

    @Get("/{city_id}/movies")
    @Operation(tags="GET")
    @ApiResponse(responseCode = "200",description = "success",content = @Content(mediaType = "application/json",schema = @Schema(implementation = MovieDto.class)))
    @ApiResponse(responseCode = "500",description = "Sql Exception",content = @Content(mediaType = "application/json",schema = @Schema(implementation = String.class)))
    public List<MovieDto> getHeartbeat(int city_id) throws SQLException {

        return movieService.getMovieByCityId(city_id);
    }

}
