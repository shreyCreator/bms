package bms.models;

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
public class SeatModel extends BaseModel {

    @Id
    @GeneratedValue
    private long id;
    private String seatNo;

    @Relation(value = Kind.MANY_TO_ONE)
    @NonNull
    @NotBlank
    private CinemaScreenModel cinemaScreen;

    @Relation(value = Kind.MANY_TO_ONE)
    @NonNull
    @NotBlank
    private CinemaModel cinema;

}
