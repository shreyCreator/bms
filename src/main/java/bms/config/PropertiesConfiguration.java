package bms.config;

import io.micronaut.runtime.context.env.ConfigurationAdvice;

@ConfigurationAdvice
public class PropertiesConfiguration {

    public String getConnectionUrl() {
        return "jdbc:postgresql://localhost:5432/bms_micronaut";
    }

    public String getDbUsername() {
        return "postgres";

    }

    public String getDbPassword() {
        return "shrey";
    }

}
