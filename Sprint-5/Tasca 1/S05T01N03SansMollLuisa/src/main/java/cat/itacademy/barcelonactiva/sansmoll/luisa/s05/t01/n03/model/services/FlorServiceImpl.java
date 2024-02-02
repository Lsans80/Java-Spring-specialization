package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n03.model.dto.FlorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FlorServiceImpl implements FlorService {

    @Autowired
    private WebClient webClient;

    @Override
    public FlorDTO addFlor(FlorDTO florDTO) {
        try {
            return webClient.post()
                    .uri("/flor/add")
                    .bodyValue(florDTO)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .block();
        } catch (WebClientResponseException e) {
            String mensajeError = e.getResponseBodyAsString();
            throw new RuntimeException("Error al agregar flor. Detalles: " + e.getRawStatusCode() + " " + mensajeError, e);

        } catch (RuntimeException e)  {
            throw new RuntimeException("Error al agregar flor. Código de error: " + e.getMessage(), e);
        }
    }

    @Override
    public FlorDTO getOneFlor(int idFlor) {

        try{
            return webClient.get()
                    .uri("/flor/getOne/{id}", idFlor)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .switchIfEmpty(Mono.empty())
                    .block();

        } catch (WebClientResponseException e) {
            String mensajeError = e.getResponseBodyAsString();
            throw new RuntimeException("Error al buscar la flor. Detalles: " + e.getRawStatusCode() + " " + mensajeError, e);

        } catch (RuntimeException e)  {
            throw new RuntimeException("Error al buscar la flor. Código de error: " + e.getMessage(), e);
        }
    }


    @Override
    public FlorDTO getOneFlor(String nombreFlor) {

        try{
            return webClient.get()
                    .uri("/flor/getOneByName/{nombre}", nombreFlor)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .block();

        } catch (WebClientResponseException e) {
            String mensajeError = e.getResponseBodyAsString();
            throw new RuntimeException("Error al buscar la flor. Detalles: " + e.getRawStatusCode() + " " + mensajeError, e);

        } catch (RuntimeException e)  {
            throw new RuntimeException("Error al buscar la flor. Código de error: " + e.getMessage(), e);
        }
    }

    @Override
    public List<FlorDTO> getAllFlores() {

        try{
            return webClient.get()
                    .uri("/flor/getAll")
                    .retrieve()
                    .bodyToFlux(FlorDTO.class)
                    .collectList()
                    .block();

        } catch (WebClientResponseException e){
            String mensajeError = e.getResponseBodyAsString();
            throw new RuntimeException("Error al buscar la lista. Detalles: " + e.getRawStatusCode() + " " + mensajeError, e);

        } catch (RuntimeException e)  {
            throw new RuntimeException("Error al buscar la lista. Código de error: " + e.getMessage(), e);
        }

    }

    @Override
    public FlorDTO updateFlor(int id, FlorDTO florDTO) {

        try {
            return webClient.put()
                    .uri("/flor/update/{id}", id)
                    .bodyValue(florDTO)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .switchIfEmpty(Mono.empty())
                    .block();

        } catch (WebClientResponseException e){
            String mensajeError = e.getResponseBodyAsString();
            throw new RuntimeException("Error al buscar la flor. Detalles: " + e.getRawStatusCode() + " " + mensajeError, e);

        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar la flor. Código de error: " + e.getMessage(), e);
        }

    }

    @Override
    public void deleteById(int idFlor) {

        try {
            webClient.delete()
                    .uri("/flor/delete/{id}", idFlor)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

        } catch (WebClientResponseException e){
            String mensajeError = e.getResponseBodyAsString();
            throw new RuntimeException("Error al buscar la flor. Detalles: " + e.getRawStatusCode() + " " + mensajeError, e);

        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar la flor. Código de error: " + e.getMessage(), e);
        }

    }

    @Override
    public void deleteByNombre(String nombreFlor) {

        try {
            webClient.delete()
                    .uri("/flor/deleteByName/{nombre}", nombreFlor)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

        } catch (WebClientResponseException e){
            String mensajeError = e.getResponseBodyAsString();
            throw new RuntimeException("Error al buscar la flor. Detalles: " + e.getRawStatusCode() + " " + mensajeError, e);

        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar la flor. Código de error: " + e.getMessage(), e);
        }

    }
}
