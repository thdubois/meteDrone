package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity

@NamedQueries({ 
	@NamedQuery(name = "findDronesById", 
				query = "SELECT u FROM Drone u WHERE u.id=:idDrone"), 
	@NamedQuery(name = "findDrones", 
				query = "SELECT u FROM Drone u")
})

public class Drone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8940788386134273107L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String model;
	
	private String name;
	
	private String city;
	
	@OneToMany
	private List<Flight> flightList;

	public Drone(){
		
	}

	public Drone(Long id, String model, String name, String city) {
		super();
		this.id = id;
		this.model = model;
		this.name = name;
		this.city = city;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}
