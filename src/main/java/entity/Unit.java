package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Unit implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, unique=true)
	private String unit;
	
	@OneToMany
	private List<Analogic> analogicList;

}
