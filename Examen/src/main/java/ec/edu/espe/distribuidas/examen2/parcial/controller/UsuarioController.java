package ec.edu.espe.distribuidas.examen2.parcial.controller;

import ec.edu.espe.distribuidas.examen2.parcial.dto.PerfilRQ;
import ec.edu.espe.distribuidas.examen2.parcial.dto.UsuarioPerfilRQ;
import ec.edu.espe.distribuidas.examen2.parcial.dto.UsuarioPerfilRS;
import ec.edu.espe.distribuidas.examen2.parcial.model.SegUsuarioPerfil;
import ec.edu.espe.distribuidas.examen2.parcial.model.SegUsuarioPerfilPK;
import ec.edu.espe.distribuidas.examen2.parcial.response.ObjectRS;
import ec.edu.espe.distribuidas.examen2.parcial.response.Response;
import ec.edu.espe.distribuidas.examen2.parcial.service.SegUsuarioService;
import ec.edu.espe.distribuidas.examen2.parcial.transform.UsuarioPerfilRSTransform;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuario")
@Slf4j
public class UsuarioController {
    private final SegUsuarioService service;

    public UsuarioController(SegUsuarioService service) {
        this.service = service;
    }

    @GetMapping("perfiles/{estado}")
    public ResponseEntity<Response> listarPerfilesActivos(@PathVariable("estado") String estado) {
        log.info("The USUARIOPERFIL info with ESTADO: {} will be searched", estado);
        List<SegUsuarioPerfil> perfiles = this.service.listAllUsuarioPerfilByEstado(estado);
        List<UsuarioPerfilRS> usuarioPerfilRS = new ArrayList<>();
        ObjectRS<List<UsuarioPerfilRS>> response = new ObjectRS<>();
        response.setPath("/v1/usuario/perfiles/{estado}");
        response.setMessage("La siguiente información fue encontrada");
        perfiles.forEach(usuarioPerfil -> {
            UsuarioPerfilRS tmp = UsuarioPerfilRSTransform.buildUsuarioPerfilRS(usuarioPerfil);
            usuarioPerfilRS.add(tmp);
        });
        response.setResponseObject(usuarioPerfilRS);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("perfiles")
    public ResponseEntity<Response> guardarPerfiles(@RequestBody UsuarioPerfilRQ request) {
        List<SegUsuarioPerfil> perfiles = new ArrayList<>();
        log.info("The list of USUARIOPERFIL will be created {}", request);
        for (PerfilRQ perfilRQ : request.getPerfiles()) {
            SegUsuarioPerfil perfil = new SegUsuarioPerfil();
            SegUsuarioPerfilPK pk = new SegUsuarioPerfilPK();
            pk.setCodigoUsuario(request.getCodigoUsuario());
            pk.setCodigoPerfil(perfilRQ.getCodigoPerfil());
            perfil.setPk(pk);
            perfiles.add(perfil);
        }
        perfiles = this.service.saveAllUsuarioPerfil(perfiles);
        ObjectRS<List<UsuarioPerfilRS>> response = new ObjectRS<>();
        response.setPath("/v1/usuario/perfiles/{estado}");
        response.setMessage("La siguiente información fue creada");
        List<UsuarioPerfilRS> usuarioPerfilRS = new ArrayList<>();
        perfiles.forEach(usuarioPerfil -> {
            UsuarioPerfilRS tmp = UsuarioPerfilRSTransform.buildUsuarioPerfilRS(usuarioPerfil);
            usuarioPerfilRS.add(tmp);
        });
        response.setResponseObject(usuarioPerfilRS);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
