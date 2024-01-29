package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n03.model.webClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class WebClientFlor {
    @Bean
    public WebClient webClient(){

        WebClient webFlor = WebClient.builder().baseUrl("http://localhost:9001").build();
        return webFlor;
    }
}