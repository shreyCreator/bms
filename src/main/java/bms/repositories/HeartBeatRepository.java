package bms.repositories;

import java.time.LocalDateTime;

import bms.models.HeartBeatModel;
import jakarta.inject.Singleton;

@Singleton
public class HeartBeatRepository {

    public HeartBeatModel getHeartbeat() {
        HeartBeatModel heartBeatModel = new HeartBeatModel(LocalDateTime.now());
        return heartBeatModel;

    }

}
