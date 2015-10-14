package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Numeric extends Sensor {

	@OneToMany
	private List<NumericData> numericDataList;

}
