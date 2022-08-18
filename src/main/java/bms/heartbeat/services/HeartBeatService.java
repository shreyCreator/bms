package bms.heartbeat.services;

import java.time.format.DateTimeFormatter;

import bms.heartbeat.models.HeartBeatModel;
import bms.heartbeat.repositories.HeartBeatRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

//TO-ASK: When to use singleton
@Singleton
public class HeartBeatService {

    @Inject
    HeartBeatRepository heartBeatRepository;

    public String getheartbeat() {
        HeartBeatModel heartBeatModel = heartBeatRepository.getHeartbeat();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formatedDateTime = dtf.format(heartBeatModel.currentDateTime);

        return formatedDateTime;
    }

}
