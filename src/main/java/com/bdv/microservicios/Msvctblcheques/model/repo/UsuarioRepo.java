package com.bdv.microservicios.Msvctblcheques.model.repo;

import com.bdv.microservicios.Msvctblcheques.model.entities.security.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario,Long> {

    Usuario findUsuarioByUsername(String username);


}
