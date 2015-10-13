package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	@OneToMany(mappedBy = "role")
	private List<User> userList;
}
