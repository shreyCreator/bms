package bms.utils;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import java.util.List;

import org.reactivestreams.Publisher;

import bms.DAOs.UserModelDao;
import bms.dtos.UserDto;
import bms.models.UserModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import bms.utils.IterableToCollection;

@Singleton
public class AuthenticationProviderUserPassword implements
        AuthenticationProvider {
    @Inject
    UserModelDao userModelDao;

    @Override
    public Flux<AuthenticationResponse> authenticate(@Nullable HttpRequest httpRequest,
            AuthenticationRequest authenticationRequest) {

        return Flux.create(emitter -> {
            String email = authenticationRequest.getIdentity().toString();
            String password = authenticationRequest.getSecret().toString();
            String enteredPass = userModelDao.getUserPassword(email);
            if (enteredPass != "" && password.equals(getDecodedPassword(enteredPass))) {
                emitter.next(AuthenticationResponse.success((String) authenticationRequest.getIdentity()));
                emitter.complete();
                return;
            }

            emitter.error(AuthenticationResponse.exception());

        }, FluxSink.OverflowStrategy.ERROR);
    }

    private String getDecodedPassword(String password) {
        byte[] decoded = Base64.getDecoder().decode(password);
        String decodedPass = new String(decoded, StandardCharsets.UTF_8);
        return decodedPass;
    }

}