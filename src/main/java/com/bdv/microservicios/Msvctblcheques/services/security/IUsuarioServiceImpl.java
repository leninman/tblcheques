package com.bdv.microservicios.Msvctblcheques.services.security;

import com.bdv.microservicios.Msvctblcheques.model.entities.security.Usuario;
import com.bdv.microservicios.Msvctblcheques.model.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUsuarioServiceImpl implements IUsuarioService {

    @Autowired
    UsuarioRepo usuarioRepo;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        usuario.setEnabled(true);
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario consultarUsuario(String nombreUsuario) {
        return usuarioRepo.findUsuarioByUsername(nombreUsuario);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepo.deleteById(idUsuario);
    }

    @Override
    public Usuario modificarusuario(Long idUsuario, Usuario usuario) {
        return null;
    }
}
