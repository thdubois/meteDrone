package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({ 
	@NamedQuery(name = "findSensorsById", 
				query = "SELECT s FROM Sensor s WHERE s.drone.id=:droneId"), 
	@NamedQuery(name = "findSensors", 
				query = "SELECT s FROM Sensor s"),
	@NamedQuery(name="findDroneSensors",
				query="SELECT s FROM Sensor s WHERE s.drone IS NOT NULL"),
	@NamedQuery(name="findRemovedSensors",
				query="SELECT s FROM Sensor s WHERE s.drone IS NULL")
})
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
	
	public Sensor(){
	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getInServiceDate() {
		return inServiceDate;
	}

	public void setInServiceDate(Date inServiceDate) {
		this.inServiceDate = inServiceDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}
		
}
