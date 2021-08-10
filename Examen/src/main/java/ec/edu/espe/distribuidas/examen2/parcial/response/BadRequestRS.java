package ec.edu.espe.distribuidas.examen2.parcial.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BadRequestRS<T> extends Response {
    private String errorMessage;
    private T requestedObject;

    @Override
    public String toString() {
        return "BadRequestRS{" + "errorMessage='" + errorMessage + '\''
                + ", requestedObject=" + requestedObject
                + ", message='" + message + '\''
                + ", path='" + path + '\'' + '}';
    }
}
