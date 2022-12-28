package com.bdv.microservicios.Msvctblcheques.model.entities;


import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
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
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Front", type = Byte[].class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Rear", type = Byte[].class),
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
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "TransmitidoOracle", type = String.class),

                })


})
public class Tblcheque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String fechaContable;



    String codBanco;



    String agencia;



    String cajero;



    String din;



    String serial;



    String banco;



    String oficina;



    String dv;



    String cuenta;



    String tranCode;



    String monto;



    String front;


    String rear;



    String corregido;



    String trasmitido;



    String cuentaDepo;



    String serialP;



    String dna;



    String estatus;



    String auxiliar1;


    String auxiliar2;


    String auxiliar3;


    String auxiliar4;


    String auxiliar5;



    String transmitidoOracle;



}
