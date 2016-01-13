package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name= "findNumerics" , 
			query="SELECT n FROM Numeric n"),
			@NamedQuery(name= "findNumeric" , 
			query="SELECT n FROM Numeric n WHERE n.id=:sensorId")
})
public class Numeric extends Sensor implements Serializable{

	private static final long serialVersionUID = -5730155873114234408L;

}
