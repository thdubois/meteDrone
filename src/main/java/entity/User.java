package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import remote.UserEJBRemote;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;
	private String mail;

	@ManyToOne
	private Role role;
	
	@ManyToOne
	private Company company;
}
