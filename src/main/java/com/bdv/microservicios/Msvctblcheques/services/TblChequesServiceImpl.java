package com.bdv.microservicios.Msvctblcheques.services;

import com.bdv.microservicios.Msvctblcheques.model.entities.Tblcheque;
import org.springframework.stereotype.Service;

@Service
public class TblChequesServiceImpl implements TblChequesService{
    @Override
    public Tblcheque consultarCheque(String banco, String oficina, String dv, String cuenta, String serial) {
        return null;
    }

    @Override
    public Tblcheque guardarCheque(Tblcheque tblcheque) {
        return null;
    }
}
