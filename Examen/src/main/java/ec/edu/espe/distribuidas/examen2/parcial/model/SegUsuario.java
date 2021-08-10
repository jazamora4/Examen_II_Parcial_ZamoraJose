package ec.edu.espe.distribuidas.examen2.parcial.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "seg_usuario", schema = "public", catalog = "examen_zamora")
public class SegUsuario {
    @Id
    @Column(name = "cod_usuario")
    private String codUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "email")
    private String email;
    @Column(name = "estado")
    private String estado;
    @Column(name = "nro_intentos_fallidos")
    private Integer nroIntentosFallidos;
    @Column(name = "fecha_ultima_sesion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaSesion;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<SegUsuarioPerfil> perfiles;
}
