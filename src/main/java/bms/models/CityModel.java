package bms.models;

import java.util.List;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.Relation.Kind;
import lombok.*;

@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CityModel extends BaseModel {

    @Id
    @GeneratedValue
    final private long id;
    @NonNull
    private String name;

    @Relation(value = Kind.MANY_TO_MANY, mappedBy = "cities")
    private List<MovieModel> movies;

    @Relation(value = Kind.ONE_TO_MANY, mappedBy = "city")
    private List<CinemaModel> cinemas;

}
