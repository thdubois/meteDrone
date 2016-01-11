package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
		@NamedQuery(name = "findFlightsById", 
					query = "SELECT f FROM Flight f WHERE f.drone.id=:idDrone"), 
		@NamedQuery(name = "findFlights", 
					query = "SELECT f FROM Flight f")
})
public class Flight implements Serializable {
	
	private static final long serialVersionUID = -762343915180969525L;

	@Id
	@GeneratedValue
	private Long id;

	private Date date;

	private String beginHour;
	
	private String endHour;

	@ManyToOne
	private Drone drone;


	public Flight() {
		
	}

	public Flight(Long id, Date date ,String beginHour,String endHour) {
		super();
		this.id = id;
		this.date = date;
		this.beginHour = beginHour;
		this.endHour = endHour;
		
	}

	public Flight( Date date ,String beginHour,String endHour) {
		super();
		this.date = date;
		this.beginHour = beginHour;
		this.endHour = endHour;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public String getBeginHour() {
		return beginHour;
	}

	public void setBeginHour(String beginHour) {
		this.beginHour = beginHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

}