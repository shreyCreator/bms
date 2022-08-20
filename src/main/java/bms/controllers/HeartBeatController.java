
package bms.controllers;

import bms.services.HeartBeatService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import java.lang.String;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/v1/heartbeat")
public class HeartBeatController {

    @Inject
    HeartBeatService heartBeatService;

    @Produces(MediaType.TEXT_PLAIN)
    @Get
    public String getHeartbeat() {

        return heartBeatService.getheartbeat();
    }

}
