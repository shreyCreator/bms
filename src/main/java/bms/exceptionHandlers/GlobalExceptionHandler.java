package bms.exceptionHandlers;

import bms.exceptions.TestException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class GlobalExceptionHandler implements ExceptionHandler<Exception, HttpResponse> {

    @Error(global = true, exception = ArithmeticException.class)
    public HttpResponse<String> handle(HttpRequest request, ArithmeticException e) {
        log.info("hi");
        return HttpResponse.serverError()
                .body("error");
    }

    @Error(exception = TestException.class)
    public HttpResponse<String> handle(HttpRequest request, TestException exception) {
        exception.printStackTrace();
        return HttpResponse.serverError(exception.getMessage());
    }

    @Override
    public HttpResponse handle(HttpRequest request, Exception exception) {
        // TODO Auto-generated method stub
        return null;
    }

}
