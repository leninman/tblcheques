package com.bdv.microservicios.Msvctblcheques.services.security;

import com.bdv.microservicios.Msvctblcheques.model.entities.security.Usuario;
import com.bdv.microservicios.Msvctblcheques.model.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class IUsuarioServiceImpl implements IUsuarioService {

    @Autowired
    UsuarioRepo usuarioRepo;

    private Usuario usuarioaguardado;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {

        Usuario usuarioconsultado=usuarioRepo.findUsuarioByUsername(usuario.getUsername());
        if(usuarioconsultado!=null){
            usuario.setId(usuarioconsultado.getId());
            usuarioconsultado.setRoles(usuario.getRoles());
            usuario.setRoles(usuarioconsultado.getRoles());
        }
        usuario.setEnabled(true);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);
        usuarioaguardado = usuarioRepo.save(usuario);

        return usuarioaguardado;

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
