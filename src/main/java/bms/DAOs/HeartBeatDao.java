package bms.DAOs;

import java.time.LocalDateTime;

import bms.models.HeartBeatModel;
import jakarta.inject.Singleton;

@Singleton
public class HeartBeatDao {

    public HeartBeatModel getHeartbeat() {
        HeartBeatModel heartBeatModel = new HeartBeatModel(LocalDateTime.now());
        return heartBeatModel;

    }

}
