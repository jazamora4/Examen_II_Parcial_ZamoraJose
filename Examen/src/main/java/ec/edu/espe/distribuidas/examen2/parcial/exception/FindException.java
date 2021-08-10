package ec.edu.espe.distribuidas.examen2.parcial.exception;

public class FindException extends RuntimeException {
    public FindException(String message) {
        super(message);
    }

    public FindException(String message, Throwable cause) {
        super(message, cause);
    }
}
