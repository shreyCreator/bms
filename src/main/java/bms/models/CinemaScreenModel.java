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
@Data
@EqualsAndHashCode(callSuper = false)
public class CinemaScreenModel extends BaseModel {

    @Id
    @GeneratedValue
    private long id;
    private String screenNo;

    @Relation(value = Kind.MANY_TO_ONE)
    @NonNull
    @NotBlank
    private CinemaModel cinema;

}
