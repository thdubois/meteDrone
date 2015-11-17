package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class Drone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8940788386134273107L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String model;
	
	@OneToMany
	private List<Flight> flightList;
}
