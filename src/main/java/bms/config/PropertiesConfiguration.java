package bms.config;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;

@Singleton
public class PropertiesConfiguration {

//    @Value("${datasources.default.url}")
        private String url;
//    @Value("${datasources.default.username}")
    private String dbName;
//    @Value("${datasources.default.password}")
    private String dbPass;
    public String getConnectionUrl() {

        return url;
    }

    public String getDbUsername() {

        return dbName;

    }

    public String getDbPassword() {
        return dbPass;
    }

}
