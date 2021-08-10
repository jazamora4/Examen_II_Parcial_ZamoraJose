package ec.edu.espe.distribuidas.examen2.parcial.service;

import ec.edu.espe.distribuidas.examen2.parcial.dao.SegPerfilRepository;
import ec.edu.espe.distribuidas.examen2.parcial.dao.SegUsuarioPerfilRepository;
import ec.edu.espe.distribuidas.examen2.parcial.dao.SegUsuarioRepository;
import ec.edu.espe.distribuidas.examen2.parcial.exception.CreateException;
import ec.edu.espe.distribuidas.examen2.parcial.model.SegPerfil;
import ec.edu.espe.distribuidas.examen2.parcial.model.SegUsuario;
import ec.edu.espe.distribuidas.examen2.parcial.model.SegUsuarioPerfil;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SegUsuarioService {
    private final SegUsuarioRepository usuarioRepository;
    private final SegUsuarioPerfilRepository usuarioPerfilRepository;
    private final SegPerfilRepository perfilRepository;

    public SegUsuarioService(SegUsuarioRepository usuarioRepository,
                             SegUsuarioPerfilRepository usuarioPerfilRepository,
                             SegPerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
        this.perfilRepository = perfilRepository;
    }

    public List<SegUsuarioPerfil> listAllUsuarioPerfilByEstado(String estado) {
        return this.usuarioPerfilRepository.findByEstadoOrderByUsuarioNombreAscPerfilNombreAscPorOmisionAsc(estado);
    }

    public List<SegUsuarioPerfil> saveAllUsuarioPerfil(List<SegUsuarioPerfil> perfiles) {
        boolean porOmisionFlag = false;
        for (SegUsuarioPerfil usuarioPerfil : perfiles) {
            Optional<SegUsuario> usuarioOptional = this.usuarioRepository.findById(
                    usuarioPerfil.getPk().getCodigoUsuario());
            Optional<SegPerfil> perfilOptional = this.perfilRepository.findById(
                    usuarioPerfil.getPk().getCodigoPerfil());
            if (usuarioOptional.isEmpty()) {
                String exceptionMessage = "The USUARIO with codigo: "
                        + usuarioPerfil.getPk().getCodigoUsuario() + " was not in the database";
                throw new CreateException(exceptionMessage);
            }
            if (perfilOptional.isEmpty()) {
                String exceptionMessage = "The PERFIL with codigo: "
                        + usuarioPerfil.getPk().getCodigoPerfil() + " was not in the database";
                throw new CreateException(exceptionMessage);
            }
            usuarioPerfil.setUsuario(usuarioOptional.get());
            usuarioPerfil.setPerfil(perfilOptional.get());
            usuarioPerfil.setEstado("ACT");
            List<SegUsuarioPerfil> perfilesAsignados = this.usuarioPerfilRepository.findByUsuarioCodUsuario(
                    usuarioPerfil.getPk().getCodigoUsuario());
            for (SegUsuarioPerfil perfil : perfilesAsignados) {
                if (perfil.getPk().getCodigoPerfil().equals(usuarioPerfil.getPk().getCodigoPerfil())) {
                    String exceptionMessage = "The USUARIO already has PERFIL with codigo: "
                            + usuarioPerfil.getPk().getCodigoPerfil();
                    throw new CreateException(exceptionMessage);
                }
                if ("S".equals(perfil.getPorOmision())) {
                    porOmisionFlag = true;
                }
            }
            if (!porOmisionFlag) {
                usuarioPerfil.setPorOmision("S");
                porOmisionFlag = true;
            } else {
                usuarioPerfil.setPorOmision("N");
            }
        }
        return this.usuarioPerfilRepository.saveAll(perfiles);
    }
}
