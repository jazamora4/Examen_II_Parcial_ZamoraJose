package ec.edu.espe.distribuidas.examen2.parcial.service;

import ec.edu.espe.distribuidas.examen2.parcial.dao.SegPerfilRepository;
import org.springframework.stereotype.Service;

@Service
public class SegPerfilService {
    private final SegPerfilRepository perfilRepository;

    public SegPerfilService(SegPerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }
}
