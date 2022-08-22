package bms.models;

import java.time.LocalDateTime;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import lombok.Data;

@Data
public class BaseModel {

    @DateCreated
    private LocalDateTime createdAt;
    @DateUpdated
    private LocalDateTime updatedAt;
    private boolean enabled = true;

}
