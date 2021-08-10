package ec.edu.espe.distribuidas.examen2.parcial.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import lombok.Data;

@Data
@Embeddable
public class SegUsuarioPerfilPK implements Serializable {
    @Column(name = "cod_usuario")
    private String codigoUsuario;
    @Column(name = "cod_perfil")
    private String codigoPerfil;

}
