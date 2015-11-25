package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import remote.UserEJBRemote;

@Named
@RequestScoped
public class UserController implements Serializable{

	private static final long serialVersionUID = -3770573459254222700L;
	
	@EJB
	private UserEJBRemote userEJB;
	
	
	private Long idCompany;	
	private String mail="jeremy";
	//private Long idRole;
	private String password;
	org.picketlink.idm.model.basic.User userPicket;
	
	@PostConstruct
	public void init(){
		userPicket= new org.picketlink.idm.model.basic.User();
	}
	
	public void addUser(){
		userEJB.createUser(getUserPicket(), idCompany, password);
	}
	public String findCompanyName(){
		return userEJB.findCompany(mail).getName();
	}
	
	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	/*public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	*/
	public org.picketlink.idm.model.basic.User getUserPicket() {
		return userPicket;
	}

	public void setUserPicket(org.picketlink.idm.model.basic.User userPicket) {
		this.userPicket = userPicket;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

}
