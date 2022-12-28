package com.bdv.microservicios.Msvctblcheques.model.repo;

import com.bdv.microservicios.Msvctblcheques.model.entities.Tblcheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblchequesRepo extends JpaRepository<Tblcheque,Long> {

}
