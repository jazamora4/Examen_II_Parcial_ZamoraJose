package ec.edu.espe.distribuidas.examen2.parcial.exception;

public class CreateException extends RuntimeException {
    public CreateException(String message) {
        super(message);
    }

    public CreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
