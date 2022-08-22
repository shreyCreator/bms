package bms.models;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Nullable;
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
@MappedEntity
public class CinemaModel extends BaseModel {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @Relation(value = Kind.MANY_TO_ONE)
    @Nullable
    @NotBlank
    private CityModel city;

}
