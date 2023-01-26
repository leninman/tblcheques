package com.bdv.microservicios.Msvctblcheques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MsvcTblchequesApplication {

	public static void main(String[] args) {

		SpringApplication.run(MsvcTblchequesApplication.class, args);
		/*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode("Microserviciotblchequesadminpassword");

		System.out.println(encodedPassword);*/

	}

}
