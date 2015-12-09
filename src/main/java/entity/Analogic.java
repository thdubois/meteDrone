package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Analogic extends Sensor implements Serializable {

	private static final long serialVersionUID = 6279249915682473657L;
	
	@ManyToOne
	private Unit unit;

}
