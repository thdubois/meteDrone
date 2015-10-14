package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Analogic extends Sensor {

	@OneToMany
	private List<AnalogicData> analogicDataList;
	
	@ManyToOne
	private Unit unit;

}
