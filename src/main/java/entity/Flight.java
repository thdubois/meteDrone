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

	private Long duration;

	@ManyToOne
	private Drone drone;


	public Flight() {
		
	}

	public Flight(Long id, Date date, Long duration) {
		super();
		this.id = id;
		this.date = date;
		this.duration = duration;
	}

	public Flight(Date date, Long duration) {
		super();
		this.date = date;
		this.duration = duration;
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

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

}