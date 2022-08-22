package bms;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Email;

import bms.models.CinemaModel;
import bms.models.CinemaScreenModel;
import bms.models.CityModel;
import bms.models.MovieModel;
import bms.models.SeatModel;
import bms.models.ShowTimeModel;
import bms.models.UserModel;
import bms.repositories.CinemaRepository;
import bms.repositories.CinemaScreenRepository;
import bms.repositories.CityRepository;
import bms.repositories.MovieRepository;
import bms.repositories.SeatRepository;
import bms.repositories.ShowTimeRepository;
import bms.repositories.UserRepository;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class Bootstrap implements
        ApplicationEventListener<ServerStartupEvent> {
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

    List<CinemaModel> listOfCinema;
    List<MovieModel> listOfMovie;

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        System.out.println("server started!!!yay");
        populateUserModel();
        populateMovieModel();
        populateCityModel();

    }

    public void populateUserModel() {
        System.out.println("server started!!!yay");

        UserModel user1 = new UserModel("shrey.agrawal@gmail.com", "shrey", "agrawal", "caw", "798399882", "passwrod");
        UserModel user2 = new UserModel("test.user@gmail.com", "test", "user", "caw", "798399882", "test");

        List<UserModel> listOfusers = List.of(user1, user2);
        userRepo.saveAll(listOfusers);

    }

    public void populateCityModel() {
        CityModel city1 = new CityModel(0, "hyd");
        CityModel city2 = new CityModel(0, "Delhi");
        List<CityModel> listOfCities = List.of(city1, city2);
        cityRepo.saveAll(listOfCities);
        populateCinemaModel(listOfCities);
    }

    public void populateBookingModel() {
        CityModel city1 = new CityModel(0, "hyd");
        CityModel city2 = new CityModel(0, "Delhi");
        List<CityModel> listOfCities = List.of(city1, city2);
        cityRepo.saveAll(listOfCities);
    }

    public void populateCinemaModel(List<CityModel> listOfCities) {
        CinemaModel cinema1 = new CinemaModel(0, "Attrium", listOfCities.get(0));
        CinemaModel cinema2 = new CinemaModel(0, "Select City", listOfCities.get(0));

        listOfCinema = List.of(cinema1, cinema2);
        cinemaRepo.saveAll(listOfCinema);
        populateCinemaScreenModel(listOfCinema);

    }

    public void populateCinemaScreenModel(List<CinemaModel> listOfCinema) {
        CinemaScreenModel cinemaScreen1 = new CinemaScreenModel(0, "1a", listOfCinema.get(0));
        CinemaScreenModel cinemaScreen2 = new CinemaScreenModel(0, "1a", listOfCinema.get(1));
        CinemaScreenModel cinemaScreen3 = new CinemaScreenModel(0, "2a", listOfCinema.get(0));

        List<CinemaScreenModel> listOfCinemaScreen = List.of(cinemaScreen1, cinemaScreen2, cinemaScreen3);
        cinemaScreenRepo.saveAll(listOfCinemaScreen);
        populateSeatModel(listOfCinemaScreen);

    }

    public void populateMovieModel() {
        MovieModel movie1 = new MovieModel(0, "rocketry", "patriotism", LocalDateTime.of(2022, 10, 13, 15, 56));
        MovieModel movie2 = new MovieModel(0, "thor", "marvel", LocalDateTime.of(2022, 10, 13, 15, 56));
        MovieModel movie3 = new MovieModel(0, "jjk", "anime", LocalDateTime.of(2022, 10, 13, 15, 56));
        listOfMovie = List.of(movie1, movie2, movie3);

        movieRepo.saveAll(listOfMovie);
    }

    public void populateSeatModel(List<CinemaScreenModel> listOfCinemaScreen) {
        SeatModel seat1 = new SeatModel(0, "1A", listOfCinemaScreen.get(0), listOfCinemaScreen.get(0).getCinema());
        SeatModel seat2 = new SeatModel(0, "1A", listOfCinemaScreen.get(1), listOfCinemaScreen.get(1).getCinema());
        SeatModel seat3 = new SeatModel(0, "1A", listOfCinemaScreen.get(2), listOfCinemaScreen.get(2).getCinema());
        SeatModel seat4 = new SeatModel(0, "2A", listOfCinemaScreen.get(0), listOfCinemaScreen.get(0).getCinema());

        List<SeatModel> listOfSeatModel = List.of(seat1, seat2, seat3, seat4);
        seatRepo.saveAll(listOfSeatModel);

        populateShowTimeModel(listOfCinemaScreen);
    }

    public void populateShowTimeModel(List<CinemaScreenModel> listOfCinemaScreen) {
        ShowTimeModel show1 = new ShowTimeModel(0, LocalDateTime.of(2022, 10, 13, 15, 56),
                LocalDateTime.of(2022, 10, 13, 17, 56),
                listOfMovie.get(0),
                listOfCinemaScreen.get(0));
        ShowTimeModel show2 = new ShowTimeModel(0, LocalDateTime.of(2022, 10, 13, 15, 56),
                LocalDateTime.of(2022, 10, 13, 17, 56),
                listOfMovie.get(1),
                listOfCinemaScreen.get(1));
        ShowTimeModel show3 = new ShowTimeModel(0, LocalDateTime.of(2022, 10, 13, 15, 56),
                LocalDateTime.of(2022, 10, 13, 17, 56),
                listOfMovie.get(2),
                listOfCinemaScreen.get(2));

        List<ShowTimeModel> listOfShowTime = List.of(show1, show2, show3);

        showTimeRepo.saveAll(listOfShowTime);
    }
}
