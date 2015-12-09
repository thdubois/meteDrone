package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "findSuscriptionById", 
				query = "SELECT s FROM Suscription s WHERE s.user.id=:idUser"), 
	@NamedQuery(name = "findSuscriptions", 
				query = "SELECT s FROM Suscription s")
})
public class Suscription implements Serializable {

	private static final long serialVersionUID = 7946321758069056304L;

	@Id
	@GeneratedValue
	private Long id;
	
	private Date dateBegin;
	
	@ManyToOne
	private Sensor sensor;
	
	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	
	
}
