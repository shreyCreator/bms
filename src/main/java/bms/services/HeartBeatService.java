package bms.services;

import java.time.format.DateTimeFormatter;

import bms.exceptions.TestException;
import bms.models.HeartBeatModel;
import bms.repositories.HeartBeatRepository;
import io.micronaut.security.authentication.AuthorizationException;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

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
