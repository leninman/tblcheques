package com.bdv.microservicios.Msvctblcheques.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity(name="TblCheques")
@IdClass(value= TblchequePK.class)
public class Tblcheque implements Serializable {




    String fechacontable;



    String codBanco;



    String agencia;



    String cajero;


    String din;

    @Id
    String serial;


    @Id
    String banco;


    @Id
    String oficina;


    @Id
    String dv;


    @Id
    String cuenta;



    String trancode;



    String monto;



    String front;


    String rear;



    String corregido;



    String transmitido;



    String cuentadepo;



    String serialp;



    String dna;



    String estatus;



    String auxiliar1;


    String auxiliar2;


    String auxiliar3;


    String auxiliar4;


    String auxiliar5;



    String transmitidooracle;





}
