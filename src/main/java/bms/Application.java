package bms;

import io.micronaut.openapi.annotation.OpenAPISecurity;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "BMS PROJECT",
                version = "v1",
                description = "all api for bms project"
        )
)
@SecurityScheme(name = "bms",scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
@OpenAPISecurity
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
