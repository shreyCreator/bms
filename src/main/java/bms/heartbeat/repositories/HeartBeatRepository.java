package bms.heartbeat.repositories;

import java.time.LocalDateTime;

import bms.heartbeat.models.HeartBeatModel;
import jakarta.inject.Singleton;

@Singleton
public class HeartBeatRepository {

    public HeartBeatModel getHeartbeat() {
        HeartBeatModel heartBeatModel = new HeartBeatModel(LocalDateTime.now());
        return heartBeatModel;

    }

}
