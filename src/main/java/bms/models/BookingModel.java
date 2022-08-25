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
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class BookingModel extends BaseModel {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private LocalDateTime releaseDateTime;

    @Relation(value = Kind.MANY_TO_ONE)
    @NonNull
    @NotBlank
    private UserModel user;

    @Relation(value = Kind.MANY_TO_ONE)
    @NonNull
    @NotBlank
    private ShowTimeModel showTime;

    @Relation(value = Kind.MANY_TO_ONE)
    @NonNull
    @NotBlank
    private SeatModel seat;

}
