package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnalogicData implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private Date date;

	private Float value;

	@ManyToOne
	private Analogic analogic;

}
