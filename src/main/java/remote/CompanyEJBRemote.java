package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.Company;

@Remote
public interface CompanyEJBRemote {
	public List<Company> findCompanies();
	public Company createCompany(String name);
	public Company findCompanyByName(String companyName);
}
