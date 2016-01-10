package entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name= "findNumerics" , 
			query="SELECT n FROM Numeric n"),
})
public class Numeric extends Sensor {

}
