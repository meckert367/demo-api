package itzbund.demo_api.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  
  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
               .group("default")
               .pathsToMatch("/users/**")
               .build();
  }
}

