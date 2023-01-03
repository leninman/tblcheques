package com.bdv.microservicios.Msvctblcheques.controller;

import com.bdv.microservicios.Msvctblcheques.model.entities.Tblcheque;
import com.bdv.microservicios.Msvctblcheques.services.TblChequesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")
public class TblChequesController {
    @Autowired
    TblChequesService tblChequesService;
    @GetMapping("getTblCheque")
    public ResponseEntity<Tblcheque> verTblCheque(
            @RequestParam String banco,
            @RequestParam String oficina,
            @RequestParam String dv,
            @RequestParam String cuenta,
            @RequestParam String serial) {



        Tblcheque tblcheque = tblChequesService.consultarTblCheque(banco,oficina,dv,cuenta,serial);
        if (tblcheque==null) {
            return ResponseEntity.notFound().build();
        }

        if (tblcheque.getFront()!=null){
            String front = tblcheque.getFront();
            tblcheque.setFront("0x".concat(front));
        }
        if(tblcheque.getRear()!=null) {
            String rear = tblcheque.getRear();
            tblcheque.setRear("0x".concat(rear));
        }

        return ResponseEntity.ok(tblcheque);
    }

    @PostMapping("saveTblCheque")
    public ResponseEntity<Tblcheque> salvarTblCheque(@RequestBody Tblcheque tblcheque){
        Tblcheque tblchequeguardado=tblChequesService.guardarTblCheque(tblcheque);
        return ResponseEntity.status(HttpStatus.CREATED).body(tblchequeguardado);

    }

}
