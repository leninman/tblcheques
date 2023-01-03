package com.bdv.microservicios.Msvctblcheques.model.entities;

import javax.persistence.Id;
import java.io.Serializable;

public class TblchequePK implements Serializable {


    String serial;

    String banco;

    String oficina;

    String dv;

    String cuenta;
}
