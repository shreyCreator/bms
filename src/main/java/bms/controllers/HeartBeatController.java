
package bms.controllers;
import bms.services.HeartBeatService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import java.lang.String;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/v1/heartbeat")
@SecurityRequirement(name = "bms")
public class HeartBeatController {

    @Inject
    HeartBeatService heartBeatService;

    @Get
    @Operation(tags = "GET")
    @ApiResponse(responseCode = "200",content = @Content(mediaType = "application/json",schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "500",description = "Internal server error")
    public String getHeartbeat() {

        return heartBeatService.getheartbeat();
    }

}
