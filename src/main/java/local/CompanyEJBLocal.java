package local;

import java.util.List;

import javax.ejb.Local;

import entity.Company;


@Local
public interface CompanyEJBLocal {
	public List<Company> findCompanies();
	public Company createCompany(String name) throws Exception;;
	public Company findCompanyByName(String companyName);
}
