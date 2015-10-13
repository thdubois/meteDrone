package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private Long id;
	
	private Date date;
	
	private Long duration;
	
	@ManyToOne
	private Drone drone;
}