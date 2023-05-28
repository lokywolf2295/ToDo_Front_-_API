package ar.com.utnfrsr.todoapp.context;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration /*la clase con esta configuracipon tiene la capacidad de crear bines, los cuales forman parte de la aplication context de spring/springboot*/
public class OpenApiConfig {
    @Bean
    public OpenAPI OngAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .info(new Info()
                        .title("ToDo API")
                        .description("La API REST de ToDo App.")
                        .version("v1"))
                .externalDocs(new ExternalDocumentation()
                        .description("")
                        .url(""))
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
