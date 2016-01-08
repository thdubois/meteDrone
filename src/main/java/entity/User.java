package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({ 
	@NamedQuery(name = "findUserById", 
				query = "SELECT u FROM User u WHERE u.id=:idUser"), 
	@NamedQuery(name = "findUsers", 
				query = "SELECT u FROM User u"),
	@NamedQuery(name = "findUserByMail", 
				query = "SELECT u FROM User u WHERE u.email=:mail")
})
public class User implements Serializable{

	private static final long serialVersionUID = 1658650721601124975L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@ManyToOne
	private Company company;
	
	@OneToMany
	private List<Suscription> suscriptionList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(){
		
	}
	
	public User(String email) {
		super();
		this.email = email;
	}

	public List<Suscription> getSuscriptionList() {
		return suscriptionList;
	}

	public void setSuscriptionList(List<Suscription> suscriptionList) {
		this.suscriptionList = suscriptionList;
	}
}
