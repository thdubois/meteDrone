package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Numeric extends Sensor implements Serializable {

	private static final long serialVersionUID = 3342298343539501528L;

}
