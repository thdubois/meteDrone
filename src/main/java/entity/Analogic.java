package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Analogic extends Sensor implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany
	private List<AnalogicData> analogicDataList;
	
	@ManyToOne
	private Unit unit;

}
