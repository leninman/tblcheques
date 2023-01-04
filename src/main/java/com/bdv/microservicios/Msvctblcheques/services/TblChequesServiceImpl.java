package com.bdv.microservicios.Msvctblcheques.services;

import com.bdv.microservicios.Msvctblcheques.model.entities.Tblcheque;
import com.bdv.microservicios.Msvctblcheques.model.repo.TblchequeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TblChequesServiceImpl implements TblChequesService{

    @Autowired
    TblchequeRepo tblchequesRepo;
    @Override
    public Tblcheque consultarTblCheque(String banco, String oficina, String dv, String cuenta, String serial) {
        return tblchequesRepo.findTblCheque(banco,oficina,dv,cuenta,serial);
    }

    @Override
    public Tblcheque guardarTblCheque(Tblcheque tblcheque) {

        String FechaContable=tblcheque.getFechacontable();
        String Cod_Banco=tblcheque.getCodBanco();
        String Agencia=tblcheque.getAgencia();
        String Cajero=tblcheque.getCajero();
        String Din=tblcheque.getDin();
        String Serial=tblcheque.getSerial();
        String Banco=tblcheque.getBanco();
        String Oficina= tblcheque.getOficina();
        String Dv= tblcheque.getDv();
        String Cuenta= tblcheque.getCuenta();
        String TranCode= tblcheque.getTrancode();
        String Monto= tblcheque.getMonto();
        String Front=(tblcheque.getFront()).substring(2);
        byte[] FrontConvertida=becomeFront(Front);
        String Rear=(tblcheque.getRear()).substring(2);
        byte[] RearConvrtida=becomeRear(Rear);
        String Corregido=tblcheque.getCorregido();
        String Transmitido=tblcheque.getTransmitido();
        String CuentaDepo= tblcheque.getCuentadepo();
        String SerialP= tblcheque.getSerialp();
        String Dna= tblcheque.getDna();
        String Estatus= tblcheque.getEstatus();
        String Auxiliar1= tblcheque.getAuxiliar1();
        String Auxiliar2= tblcheque.getAuxiliar2();
        String Auxiliar3= tblcheque.getAuxiliar3();
        String Auxiliar4= tblcheque.getAuxiliar4();
        String Auxiliar5= tblcheque.getAuxiliar5();
        String TransmitidoOracle= tblcheque.getTransmitidooracle();


        tblchequesRepo.sp_ICS_tblCheques("INSERT",FechaContable,Cod_Banco,Agencia,Cajero,Din,Serial,Banco,Oficina,Dv,Cuenta);

















        return tblcheque;
    }

    private byte[] becomeFront(String front){
        byte[] ans = new byte[front.length() / 2];
        for (int i = 0; i < ans.length; i++) {
            int index = i * 2;
            // Using parseInt() method of Integer class
            int val = Integer.parseInt(front.substring(index, index + 2), 16);
            ans[i] = (byte)val;
        }
        byte[] Front2=ans;
        return Front2;
    }

    private byte[] becomeRear(String rear){
        byte[] ans2 = new byte[rear.length() / 2];
        for (int j = 0; j < ans2.length; j++) {
            int index = j * 2;
            // Using parseInt() method of Integer class
            int val = Integer.parseInt(rear.substring(index, index + 2), 16);
            ans2[j] = (byte)val;
        }
        byte[] Rear2=ans2;
        return Rear2;
    }
}
