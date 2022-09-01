package bms.dtos;

import bms.models.CityModel;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CinemaDto {

    private int showtime_id;
    private String movie_name;
    private String cinema_name;
    private String start_time;
    private String end_time;

}
