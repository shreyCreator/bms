
package bms.controllers;

import bms.dtos.SeatDto;
import bms.models.UserModel;
import bms.services.UserService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import java.lang.String;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/register/")
public class UserController {
    @Inject
    UserService userservice;

    @Post
    @Operation(tags="POST")
    @ApiResponse(responseCode = "200",description = "success",content = @Content(mediaType = "application/json",schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "500",description = " Exception",content = @Content(mediaType = "application/json",schema = @Schema(implementation = String.class)))
    public String saveUser(@Body UserModel user) throws Exception {
        return userservice.saveUser(user);

    }

}
