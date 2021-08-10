package ec.edu.espe.distribuidas.examen2.parcial.dto;

import java.util.List;
import lombok.Data;

@Data
public class UsuarioPerfilRQ {
    private String codigoUsuario;
    private List<PerfilRQ> perfiles;
}
