package com.bdv.microservicios.Msvctblcheques.model.repo;

import com.bdv.microservicios.Msvctblcheques.model.entities.security.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepo extends JpaRepository<Rol,Long> {
}
