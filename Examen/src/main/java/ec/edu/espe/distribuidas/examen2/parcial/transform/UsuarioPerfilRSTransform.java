package ec.edu.espe.distribuidas.examen2.parcial.transform;

import ec.edu.espe.distribuidas.examen2.parcial.dto.UsuarioPerfilRS;
import ec.edu.espe.distribuidas.examen2.parcial.model.SegUsuarioPerfil;

public class UsuarioPerfilRSTransform {
    public static UsuarioPerfilRS buildUsuarioPerfilRS(SegUsuarioPerfil usuarioPerfil) {
        return UsuarioPerfilRS.builder()
                .codigoUsuario(usuarioPerfil.getUsuario().getCodUsuario())
                .identificacionUsuario(usuarioPerfil.getUsuario().getIdentificacion())
                .codigoPerfil(usuarioPerfil.getPerfil().getCodigoPerfil())
                .nombre(usuarioPerfil.getPerfil().getNombre())
                .estado(usuarioPerfil.getEstado())
                .build();

    }
}
