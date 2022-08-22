
package bms.controllers;

import bms.exceptions.TestException;
import bms.models.CinemaModel;
import bms.models.MovieModel;
import bms.models.SeatModel;
import bms.models.UserModel;
import bms.repositories.CinemaRepository;
import bms.repositories.CinemaScreenRepository;
import bms.repositories.CityRepository;
import bms.repositories.MovieRepository;
import bms.repositories.SeatRepository;
import bms.repositories.ShowTimeRepository;
import bms.repositories.UserRepository;
import bms.services.HeartBeatService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.AuthorizationException;
import io.micronaut.security.rules.SecurityRule;
import java.lang.String;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/test")
public class TestController {

    @Inject
    private UserRepository userRepo;
    @Inject
    private CityRepository cityRepo;
    @Inject
    private CinemaRepository cinemaRepo;
    @Inject
    private CinemaScreenRepository cinemaScreenRepo;
    @Inject
    private MovieRepository movieRepo;
    @Inject
    private SeatRepository seatRepo;
    @Inject
    private ShowTimeRepository showTimeRepo;

    @Get
    public Iterable<CinemaModel> getHeartbeat() {

        return cinemaRepo.findAll();
    }

}
