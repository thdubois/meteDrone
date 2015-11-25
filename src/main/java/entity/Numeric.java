package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Numeric extends Sensor implements Serializable {

	private static final long serialVersionUID = -5047633522227576493L;
	@OneToMany
	private List<NumericData> numericDataList;

}
