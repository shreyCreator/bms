package bms.controllers;

import java.sql.SQLException;
import java.util.List;

import bms.dtos.MovieDto;
import bms.services.MovieService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/cities")
public class MovieController {

    @Inject
    MovieService movieService;

    @Get("/{city_id}/movies")
    public List<MovieDto> getHeartbeat(int city_id) throws SQLException {

        return movieService.getMovieByCityId(city_id);
    }

}
