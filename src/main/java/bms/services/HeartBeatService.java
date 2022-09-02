package bms.services;

import java.time.format.DateTimeFormatter;

import bms.DAOs.HeartBeatDao;
import bms.models.HeartBeatModel;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class HeartBeatService {

    @Inject
    HeartBeatDao heartBeatRepository;

    public String getheartbeat() {

        HeartBeatModel heartBeatModel = heartBeatRepository.getHeartbeat();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formatedDateTime = dtf.format(heartBeatModel.currentDateTime);
        return formatedDateTime;

    }

}
