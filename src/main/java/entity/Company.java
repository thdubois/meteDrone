package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany
	private List<User> userList;

}
