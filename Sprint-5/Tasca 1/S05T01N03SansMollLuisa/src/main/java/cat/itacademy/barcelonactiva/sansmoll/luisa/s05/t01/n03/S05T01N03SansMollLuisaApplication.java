package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n03;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S05T01N03SansMollLuisaApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N03SansMollLuisaApplication.class, args);
	}

	//No es necesario este @Bean pero si queremos customizar la vista yes!
	@Bean
	public OpenAPI api() {
		return new OpenAPI().info(new Info()
				.title("API Flor Definition")
				.version("0.11")
				.description("Documentation for API Flor Swagger")
				.termsOfService("http://swagger.io/terms")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
