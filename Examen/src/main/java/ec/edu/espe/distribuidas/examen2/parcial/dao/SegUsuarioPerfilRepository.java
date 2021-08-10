package ec.edu.espe.distribuidas.examen2.parcial.dao;

import ec.edu.espe.distribuidas.examen2.parcial.model.SegUsuarioPerfil;
import ec.edu.espe.distribuidas.examen2.parcial.model.SegUsuarioPerfilPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegUsuarioPerfilRepository extends JpaRepository<SegUsuarioPerfil, SegUsuarioPerfilPK> {
    List<SegUsuarioPerfil> findByEstadoOrderByPerfilNombre(String estado);
}