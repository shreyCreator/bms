
package bms.controllers;

import bms.models.UserModel;
import bms.services.UserService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
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
    public String saveUser(@Body UserModel user) throws Exception {
        return userservice.saveUser(user);

    }

}
