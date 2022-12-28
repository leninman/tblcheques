package com.bdv.microservicios.Msvctblcheques.model.repo;

import com.bdv.microservicios.Msvctblcheques.model.entities.Tblcheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblchequesRepo extends JpaRepository<Tblcheque,Long> {

    @Procedure
    void sp_ICS_tblCheques(@Param("Accion") String Accion,
                           @Param("FechaContable") String FechaContable,
                           @Param("Cod_Banco") String Cod_Banco,
                           @Param("Agencia") String Agencia,
                           @Param("Cajero") String Cajero,
                           @Param("Din") String Din,
                           @Param("Serial") String Serial,
                           @Param("Banco") String Banco,
                           @Param("Oficina") String Oficina,
                           @Param("Dv") String Dv,
                           @Param("Cuenta") String Cuenta
                           );
}
