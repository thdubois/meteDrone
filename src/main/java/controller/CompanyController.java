package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import remote.CompanyEJBRemote;
import remote.UserEJBRemote;

import entity.Company;
import entity.User;

@Named
@RequestScoped
public class CompanyController implements Serializable{

	private static final long serialVersionUID = -7409725665370146963L;
	@EJB
	private CompanyEJBRemote companyEJB;

	@EJB
	private UserEJBRemote userEJB;

	private List<Company> companies;
	private String name;
	private Boolean errorMessage = false;

	public void addCompany(){
		try{
			companyEJB.createCompany(name);		
		}
		catch (Exception e){
			setErrorMessage(true);
		}
	}

	public List<Company> getCompanies() {
		return companyEJB.findCompanies();
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public void deleteCompany(Long companyId){
		List<User> users=userEJB.findUserByCompany(companyId);
		for (User u: users){
			userEJB.deleteCompany(u);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(Boolean errorMessage) {
		this.errorMessage = errorMessage;
	}



}
