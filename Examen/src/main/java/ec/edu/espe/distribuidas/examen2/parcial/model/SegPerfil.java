package ec.edu.espe.distribuidas.examen2.parcial.model;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "seg_perfil", schema = "public", catalog = "examen_zamora")
public class SegPerfil {
    @Id
    @Column(name = "cod_perfil")
    private String codigoPerfil;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private String estado;
}
