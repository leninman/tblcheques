package com.bdv.microservicios.Msvctblcheques.model.repo;

import com.bdv.microservicios.Msvctblcheques.model.entities.Tblcheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblchequeRepo extends JpaRepository<Tblcheque,Long> {



 /*   @Query(value="SELECT a.FechaContable as Fechacontable," +
            "a.Cod_Banco as Codbanco," +
            "a.Agencia," +
            "a.Cajero," +
            "a.Din," +
            "a.Serial," +
            "a.Banco," +
            "a.Oficina," +
            "a.Dv," +
            "a.Cuenta," +
            "a.TranCode as Trancode," +
            "a.Monto," +
            "a.Front," +
            "a.Rear," +
            "a.Corregido," +
            "a.Transmitido," +
            "a.CuentaDepo as Cuentadepo," +
            "a.SerialP as Serialp," +
            "a.Dna," +
            "a.Estatus," +
            "a.Auxiliar1," +
            "a.Auxiliar2," +
            "a.Auxiliar3," +
            "a.Auxiliar4," +
            "a.Auxiliar5," +
            "a.TransmitidoOracle as Transmitidooracle " +
            "FROM " +
            "TblCheques a " +
            "WHERE " +
            "Banco=?1 and Oficina=?2 and Dv=?3 and Cuenta=?4 and Serial=?5",nativeQuery = true)
    Tblcheque findTblCheque(String banco, String oficina, String dv, String cuenta, String serial);*/





    @Query(value="SELECT * " +
            "FROM " +
            "TblCheques a " +
            "WHERE " +
            "Banco=?1 and Oficina=?2 and Dv=?3 and Cuenta=?4 and Serial=?5",nativeQuery = true)
    Tblcheque findTblCheque(String banco, String oficina, String dv, String cuenta, String serial);








    @Procedure
    Tblcheque sp_ICS_tblCheques(@Param("Accion") String Accion,
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
