package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
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
	
}
