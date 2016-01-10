package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name= "findCompany" , 
			query="SELECT c FROM User u,Company c WHERE u.email=:mail AND u.company.id=c.id"),
	@NamedQuery(name = "findCompanies", 
				query = "SELECT c FROM Company c"),
	@NamedQuery(name= "findCompanyByName" , 
				query="SELECT c FROM Company c WHERE c.name=:companyName"),
})

public class Company implements Serializable {

	private static final long serialVersionUID = 5032221260864064561L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false,unique=true)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
