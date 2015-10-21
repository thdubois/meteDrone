package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Numeric extends Sensor implements Serializable {

	@OneToMany
	private List<NumericData> numericDataList;

}
