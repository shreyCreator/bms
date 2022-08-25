
package bms.controllers;

import java.util.List;

import bms.dtos.CinemaDto;
import bms.services.CinemaService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/movies")
public class CinemaController {
    @Inject
    CinemaService cinemaService;

    @Get("/{movie_id}/cinemas")
    public List<CinemaDto> saveUser(int movie_id) throws Exception {
        return cinemaService.getCinemaByMovieId(movie_id);

    }

}
