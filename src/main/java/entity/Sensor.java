package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sensor {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String model;
	
	private Date inServiceDate;
	
	private Float price;
	
	@ManyToOne
	private Drone drone;
	
	@OneToMany
	private List<Suscription> suscriptionList;
}
