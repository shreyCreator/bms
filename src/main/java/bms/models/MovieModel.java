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
@Data
@EqualsAndHashCode(callSuper = false)
@MappedEntity
public class MovieModel extends BaseModel {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private LocalDateTime releaseDateTime;

}
