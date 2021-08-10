package ec.edu.espe.distribuidas.examen2.parcial.dao;

import ec.edu.espe.distribuidas.examen2.parcial.model.SegPerfil;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegPerfilRepository extends JpaRepository<SegPerfil, String> {
    List<SegPerfil> findByEstadoOrderByNombre(String estado);
}