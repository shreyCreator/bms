package bms.heartbeat.models;

import java.time.LocalDateTime;

import jakarta.inject.Singleton;

@Singleton
public class HeartBeatModel {
    public LocalDateTime currentDateTime;

    public HeartBeatModel(LocalDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

}
