package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Suscription implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	private Date dateBegin;
	
	@ManyToOne
	private Sensor sensor;
}
