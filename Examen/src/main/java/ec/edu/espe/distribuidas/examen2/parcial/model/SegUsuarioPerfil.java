package ec.edu.espe.distribuidas.examen2.parcial.model;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "seg_usuario_perfil", schema = "public", catalog = "examen_zamora")
public class SegUsuarioPerfil {
    @EmbeddedId
    private SegUsuarioPerfilPK pk;
    @Column(name = "estado")
    private String estado;
    @Column(name = "por_omision")
    private String porOmision;
    @MapsId("codigoUsuario")
    @JoinColumn(name = "cod_usuario",
            referencedColumnName = "cod_usuario",
            nullable = false,
            insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    private SegUsuario usuario;
    @MapsId("codigoPerfil")
    @JoinColumn(name = "cod_perfil",
            referencedColumnName = "cod_perfil",
            nullable = false,
            insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    @ToString.Exclude
    private SegPerfil perfil;

}
