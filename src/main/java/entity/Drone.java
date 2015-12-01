package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	private Long id;
	
	private String model;
	
	@OneToMany
	private List<Flight> flightList;

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
	
	
}
