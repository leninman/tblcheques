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
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Tblcheque",
                procedureName = "sp_ICS_tblCheques",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Accion", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "FechaContable", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Cod_Banco", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Agencia", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Cajero", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Din", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Serial", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Banco", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Oficina", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Dv", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Cuenta", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "TranCode", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Monto", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Front", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Rear", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Corregido", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Transmitido", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "CuentaDepo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "SerialP", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Dna", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Estatus", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Auxiliar1", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Auxiliar2", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Auxiliar3", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Auxiliar4", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Auxiliar5", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "TransmitidoOracle", type = String.class)

                })


})
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
