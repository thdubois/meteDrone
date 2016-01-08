package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.Company;


@Remote
public interface CompanyEJBRemote {
	public List<Company> findCompanies();
	public Long createCompany(String name);
}
