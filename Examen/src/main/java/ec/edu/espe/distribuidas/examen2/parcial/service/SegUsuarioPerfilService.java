package ec.edu.espe.distribuidas.examen2.parcial.service;

import ec.edu.espe.distribuidas.examen2.parcial.dao.SegUsuarioPerfilRepository;
import org.springframework.stereotype.Service;

@Service
public class SegUsuarioPerfilService {
    private final SegUsuarioPerfilRepository usuarioPerfilRepository;

    public SegUsuarioPerfilService(SegUsuarioPerfilRepository usuarioPerfilRepository) {
        this.usuarioPerfilRepository = usuarioPerfilRepository;
    }
}
