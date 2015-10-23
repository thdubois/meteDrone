package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
@NamedQuery(name="findFlights", query="SELECT f FROM Flight f")
@Entity
public class Flight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -762343915180969525L;

	@Id
	@GeneratedValue
	private Long id;
	
	private Date date;
	
	private Long duration;
	
	@ManyToOne
	private Drone drone;
}