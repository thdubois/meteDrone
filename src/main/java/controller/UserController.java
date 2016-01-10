package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.model.basic.BasicModel;

import entity.User;
import remote.CompanyEJBRemote;
import remote.UserEJBRemote;

@Named
@RequestScoped
public class UserController implements Serializable{

	private static final long serialVersionUID = -3770573459254222700L;
	
	@EJB
	private UserEJBRemote userEJB;
	
	@EJB
	private CompanyEJBRemote companyEJB;
	
    @Inject 
    private IdentityManager identityManager;
    
	private Long idCompany;
	private String companyName;
	private String mail;
	private String password;
	org.picketlink.idm.model.basic.User userPicket;
	private String role;
	
	@PostConstruct
	public void init(){
		userPicket= new org.picketlink.idm.model.basic.User();
	}
	
	public void addUser(){
		
		userEJB.createUser(getUserPicket(),companyName,role,password);
	}
	
	public List<org.picketlink.idm.model.basic.User> findUsers(){
		List<User> users = userEJB.findUsers();
		List<org.picketlink.idm.model.basic.User> userPicket= new ArrayList<org.picketlink.idm.model.basic.User>();
		for(User user: users){
			userPicket.add(BasicModel.getUser(identityManager,user.getEmail()));
		}
		return userPicket;
	}
		
	public Long findUserBymail(String email){
		return userEJB.findUserByMail(email).getId();
	}
	
	public String findCompanyName(String email){
		return userEJB.findCompany(email).getName();
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}
	
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
