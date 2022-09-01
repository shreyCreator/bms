package bms.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.Relation.Kind;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class ShowTimeModel extends BaseModel {

    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Relation(value = Kind.MANY_TO_ONE)
    @NonNull
    @NotBlank
    private MovieModel movie;

    @Relation(value = Kind.MANY_TO_ONE)
    @NonNull
    @NotBlank
    private CinemaScreenModel cinemaScreen;

}
