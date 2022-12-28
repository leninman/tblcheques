package com.bdv.microservicios.Msvctblcheques.services;

import com.bdv.microservicios.Msvctblcheques.model.entities.Tblcheque;

public interface TblChequesService {

    Tblcheque consultarCheque(String banco,String oficina,String dv,String cuenta, String serial);


    Tblcheque guardarCheque(Tblcheque tblcheque);


}
