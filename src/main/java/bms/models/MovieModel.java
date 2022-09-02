package bms.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.Relation.Kind;
import io.micronaut.data.jdbc.annotation.JoinColumn;
import io.micronaut.data.jdbc.annotation.JoinTable;
import lombok.*;

@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class MovieModel extends BaseModel {

    @Id
    @GeneratedValue
    final private long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private LocalDateTime releaseDateTime;

    @Relation(value = Kind.MANY_TO_MANY)
    @JoinTable(name = "movie_city_model")
    private List<CityModel> cities = new ArrayList<>();

}
