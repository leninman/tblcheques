package com.bdv.microservicios.Msvctblcheques.controller;

import com.bdv.microservicios.Msvctblcheques.model.entities.Tblcheque;
import com.bdv.microservicios.Msvctblcheques.model.entities.security.AuthenticationRequest;
import com.bdv.microservicios.Msvctblcheques.model.entities.security.TokenInfo;
import com.bdv.microservicios.Msvctblcheques.model.entities.security.Usuario;
import com.bdv.microservicios.Msvctblcheques.services.TblChequesService;
import com.bdv.microservicios.Msvctblcheques.services.security.IUsuarioService;
import com.bdv.microservicios.Msvctblcheques.services.security.JwtUtilService;
import com.bdv.microservicios.Msvctblcheques.services.security.UsuarioDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("app")
public class TblChequesController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UsuarioDetailsService usuarioDetailsService;
    @Autowired
    JwtUtilService jwtService;
    private static final Logger logger = LoggerFactory.getLogger(TblChequesController.class);
    @Autowired
    TblChequesService tblChequesService;
    @Autowired
    IUsuarioService usuarioService;

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

    @PostMapping("authenticate")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
            logger.info("Autenticando al usuario {}",authenticationRequest.getUsuario());
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsuario(),
                authenticationRequest.getClave()));

            final UserDetails userDetails=usuarioDetailsService.loadUserByUsername(authenticationRequest.getUsuario());

            final String jwt = jwtService.generateToken(userDetails);

            TokenInfo tokenInfo=new TokenInfo(jwt);

            return ResponseEntity.ok(tokenInfo);

    }


    @PostMapping("crearusuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario usuarioguardado=usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioguardado);
    }


}
