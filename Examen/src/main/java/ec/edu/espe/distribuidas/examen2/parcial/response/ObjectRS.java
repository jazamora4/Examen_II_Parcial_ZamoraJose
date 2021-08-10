package ec.edu.espe.distribuidas.examen2.parcial.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ObjectRS<T> extends Response {
    private T responseObject;

    @Override
    public String toString() {
        return "SearchRS{" + "message='" + message + '\''
                + ", path='" + path + '\''
                + ", searchResponseObject=" + responseObject + '}';
    }
}
