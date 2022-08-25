package bms.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.context.condition.TrueCondition;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.Relation.Kind;
import io.micronaut.data.jdbc.annotation.JoinColumn;
import io.micronaut.data.jdbc.annotation.JoinTable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CinemaModel extends BaseModel {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @Relation(value = Kind.MANY_TO_ONE)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityModel city;

}
