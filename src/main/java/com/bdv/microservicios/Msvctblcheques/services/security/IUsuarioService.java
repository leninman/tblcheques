package com.bdv.microservicios.Msvctblcheques.services.security;

import com.bdv.microservicios.Msvctblcheques.model.entities.security.Usuario;

public interface IUsuarioService {
    Usuario salvarUsuario(Usuario usuario);

    Usuario consultarUsuario(String nombreUsuario);

    void eliminarUsuario(Long idUsuario);

    Usuario modificarusuario(Long idUsuario,Usuario usuario);

}
