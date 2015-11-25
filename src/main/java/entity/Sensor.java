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

	private static final long serialVersionUID = 5357810278215226315L;

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
}
