package bms.models;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@MappedEntity
public class CityModel extends BaseModel {

    @Id
    @GeneratedValue
    private long id;
    private String name;

}
