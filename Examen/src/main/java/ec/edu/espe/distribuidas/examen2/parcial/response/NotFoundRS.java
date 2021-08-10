package ec.edu.espe.distribuidas.examen2.parcial.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotFoundRS<T> extends Response {
    private String errorMessage;
    private T searchParameters;

    @Override
    public String toString() {
        return "NotFoundRS{" + "errorMessage='" + errorMessage + '\''
                + ", searchParameters=" + searchParameters
                + ", message='" + message + '\''
                + ", path='" + path + '\'' + '}';
    }
}
