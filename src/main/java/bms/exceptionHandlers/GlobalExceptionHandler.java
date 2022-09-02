package bms.exceptionHandlers;

import java.sql.SQLException;

import bms.exceptions.TestException;
import bms.exceptions.UserExistException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Controller
@Singleton
@Slf4j
public class GlobalExceptionHandler {

    @Error(exception = ArithmeticException.class, global = true) //
    public HttpResponse<String> error(HttpRequest request, ArithmeticException e) {
        log.info(e.toString());

        return HttpResponse.<String>serverError()
                .body("airthmatic exception"); //
    }

    @Error(exception = TestException.class, global = true) //
    public HttpResponse<String> Testexception(HttpRequest request, TestException e) {
        log.info(e.getMessage());

        return HttpResponse.<String>serverError()
                .body("Test exception"); //
    }

    @Error(exception = UserExistException.class, global = true) //
    public HttpResponse<String> UserException(HttpRequest request, TestException e) {
        log.info(e.getMessage());

        return HttpResponse.<String>serverError()
                .body("user already exists"); //
    }

    @Error(exception = SQLException.class, global = true) //
    public HttpResponse<String> SQLException(HttpRequest request, SQLException e) {
        log.info(e.getMessage());

        return HttpResponse.<String>serverError()
                .body("some sql exception occ"); //
    }

}
