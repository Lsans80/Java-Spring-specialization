package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n03.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleRuntimeException(WebClientResponseException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if (e.getStatusCode()== HttpStatus.CONFLICT) {
            httpStatus = HttpStatus.CONFLICT;
        } else if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>("Error en tiempo de ejecución: " + e.getMessage(), httpStatus);
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>("Error en tiempo de ejecución: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}