package bms.dtos;

import io.micronaut.context.annotation.Prototype;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
    private String email;
    private String status;
    private int seat_id;
}
