package ec.edu.espe.distribuidas.examen2.parcial.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioPerfilRS {
    private String codigoUsuario;
    private String identificacionUsuario;
    private String nombreUsuario;
    private String codigoPerfil;
    private String nombre;
    private String estado;
    private String porOmision;
}
