package ec.edu.espe.distribuidas.examen2.parcial.dao;

import ec.edu.espe.distribuidas.examen2.parcial.model.SegUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegUsuarioRepository extends JpaRepository<SegUsuario, String> {
}