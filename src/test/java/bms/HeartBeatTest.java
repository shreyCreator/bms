package bms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
public class HeartBeatTest {
    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testHeartbeat() {
        HttpRequest<String> request = HttpRequest.GET("/v1/heartbeat");
        String resp = client.toBlocking().retrieve(request);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime currentDateTime = LocalDateTime.now();

        String currentDateTimeFormatted = dtf.format(currentDateTime);

        assertEquals(resp, currentDateTimeFormatted);
    }

}
