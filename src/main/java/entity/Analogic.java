package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name= "findAnalogics" , 
			query="SELECT a FROM Analogic a"),
	@NamedQuery(name= "findAnalogic" , 
			query="SELECT a FROM Analogic a WHERE a.id=:sensorId")
})
public class Analogic extends Sensor implements Serializable {

	private static final long serialVersionUID = 6675251974356677589L;
	@ManyToOne
	private Unit unit;

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}
