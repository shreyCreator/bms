package bms.models;

import java.time.LocalDateTime;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import lombok.Data;

@Data
public class BaseModel {

    @DateCreated
    @Nullable
    private LocalDateTime createdAt;
    @DateUpdated
    @Nullable
    private LocalDateTime updatedAt;
    @Nullable
    private boolean isDeleted = false;

}
