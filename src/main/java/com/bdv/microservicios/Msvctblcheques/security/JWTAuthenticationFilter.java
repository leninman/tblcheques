package com.bdv.microservicios.Msvctblcheques.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        AuthCredentials authCredentials = new AuthCredentials();
        try{
            authCredentials=new ObjectMapper().readValue(request.getReader(),AuthCredentials.class);
        }catch (IOException e) {

        }

        UsernamePasswordAuthenticationToken userNamePAT=new UsernamePasswordAuthenticationToken(
              authCredentials.getUsername(),
                authCredentials.getPassword(),
                Collections.emptyList()
        );


        return getAuthenticationManager().authenticate(userNamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UsersDetailsImpl usersDetails= (UsersDetailsImpl) authResult.getPrincipal();
        String token=TokenUtils.createToken(usersDetails.getNombre(),usersDetails.getUsername());
        response.addHeader("Authorization","Bearer " + token);
        super.successfulAuthentication(request, response, chain, authResult);
        response.getWriter().flush();
    }
}
