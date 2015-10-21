package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQuery(name="findSensorByName", query = "SELECT s FROM Sensor s WHERE s.name='toto'")
@Entity
public class Sensor implements Serializable {
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
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
}
