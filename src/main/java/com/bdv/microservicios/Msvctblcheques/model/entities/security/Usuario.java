package com.bdv.microservicios.Msvctblcheques.model.entities.security;

import com.bdv.microservicios.Msvctblcheques.model.entities.security.Rol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10, unique = true)
	private String username;

	@Column(length = 100)
	private String password;



	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Rol> roles;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
