package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.exceptions;

public class FlorNotFound extends RuntimeException {
    public FlorNotFound (String mensaje){
        super(mensaje);
    }
}
