package com.bdv.microservicios.Msvctblcheques.security;

import com.bdv.microservicios.Msvctblcheques.model.entities.Usuario;
import com.bdv.microservicios.Msvctblcheques.model.repo.UsuarioRepo;
import com.bdv.microservicios.Msvctblcheques.security.UsersDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Usuario usuario = usersRepo.findUsuarioByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("El usuario: " + username + "no existe"));

            return new UsersDetailsImpl(usuario);
    }
}
