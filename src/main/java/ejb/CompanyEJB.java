package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import local.CompanyEJBLocal;
import remote.CompanyEJBRemote;
import entity.Company;


@Stateless
public class CompanyEJB implements CompanyEJBRemote, CompanyEJBLocal {
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public List<Company> findCompanies() {
		TypedQuery<Company> query=em.createNamedQuery("findCompanies",Company.class);
		return query.getResultList();
	}
	
	public Long createCompany(String name){
		Company companyEntity = new Company();
		companyEntity.setName(name);
		em.persist(companyEntity);
		return companyEntity.getId();
	}
	
}
