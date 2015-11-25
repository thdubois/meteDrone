package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1658650721601124975L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@ManyToOne
	private Company company;

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
	

}
