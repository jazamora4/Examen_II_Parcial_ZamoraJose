package ec.edu.espe.distribuidas.examen2.parcial.exception;

public class DeleteException extends RuntimeException {
    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
