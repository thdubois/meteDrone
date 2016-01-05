package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import remote.CompanyEJBRemote;
import entity.Company;

@Named
@RequestScoped
public class CompanyController implements Serializable{
	
	private static final long serialVersionUID = -7409725665370146963L;
	@EJB
	private CompanyEJBRemote companyEJB;
	private List<Company> companies;
	private String name;

	public List<Company> getCompanies() {
		return companyEJB.findCompanies();
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
