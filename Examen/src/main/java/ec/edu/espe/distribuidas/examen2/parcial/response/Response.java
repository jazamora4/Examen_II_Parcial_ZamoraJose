package ec.edu.espe.distribuidas.examen2.parcial.response;

import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class Response {
    protected String message;
    protected String path;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Response response = (Response) o;
        return Objects.equals(message, response.message) && Objects.equals(path, response.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, path);
    }
}
