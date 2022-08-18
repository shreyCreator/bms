package bms.heartbeat.controllers;

import java.sql.Timestamp;

import bms.heartbeat.services.HeartBeatService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/v1/heartbeat")
public class HeartBeatController {
    @Inject
    HeartBeatService heartBeatService;

    @Get(produces = MediaType.TEXT_PLAIN)
    public String getHeartbeat() {
        return heartBeatService.getheartbeat();
    }

}
