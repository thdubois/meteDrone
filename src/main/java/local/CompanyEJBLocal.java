package local;

import java.util.List;

import javax.ejb.Local;

import entity.Company;


@Local
public interface CompanyEJBLocal {
	public List<Company> findCompanies();
	public Long createCompany(String name);
}
