package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Drone {
	@Id
	@GeneratedValue
	private Long id;
	
	private String model;
	
	@OneToMany
	private List<Flight> flightList;
}
