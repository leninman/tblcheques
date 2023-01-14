package com.bdv.microservicios.Msvctblcheques.config;

import com.bdv.microservicios.Msvctblcheques.security.JwtRequestFilter;
import com.bdv.microservicios.Msvctblcheques.services.security.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UsuarioDetailsService usuarioDetailsService;
    @Autowired
    JwtRequestFilter jwtRequestFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.httpBasic(withDefaults()).authorizeRequests()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/app/authenticate").permitAll()
                .antMatchers("/app/getTblCheque?**").hasRole("admin")
                .antMatchers("/app/saveTblCheque?**").hasRole("admin")
                .anyRequest().authenticated()
                .and().cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(usuarioDetailsService);

       /* auth.inMemoryAuthentication().withUser("Tblcheque").password("{noop}"+"Microserviciotblechequepassword").roles("admin")
                .and()
                .withUser("user").password("{noop}"+"12345").roles("user");*/
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
