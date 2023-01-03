package com.bdv.microservicios.Msvctblcheques.services;

import com.bdv.microservicios.Msvctblcheques.model.entities.Tblcheque;

public interface TblChequesService {

    Tblcheque consultarTblCheque(String banco,String oficina,String dv,String cuenta, String serial);


    Tblcheque guardarTblCheque(Tblcheque tblcheque);


}
