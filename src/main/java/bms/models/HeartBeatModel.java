package bms.models;

import java.time.LocalDateTime;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Singleton
public class HeartBeatModel {
    public LocalDateTime currentDateTime;

}
