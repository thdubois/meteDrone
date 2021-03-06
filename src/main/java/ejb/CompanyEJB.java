package ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import local.CompanyEJBLocal;
import remote.CompanyEJBRemote;
import entity.Company;


@Stateless
public class CompanyEJB implements CompanyEJBRemote, CompanyEJBLocal, Serializable {

	private static final long serialVersionUID = -8425285573954583409L;
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public List<Company> findCompanies() {
		TypedQuery<Company> query=em.createNamedQuery("findCompanies",Company.class);
		return query.getResultList();
	}
	
	public Company createCompany(String name) throws Exception{
		Company companyEntity = new Company();
		companyEntity.setName(name);
		em.persist(companyEntity);
		return companyEntity;
	}
	
	public Company findCompanyByName(String companyName){
		try{
			TypedQuery<Company> query = em.createNamedQuery("findCompanyByName", Company.class).setParameter("companyName",companyName);
			return query.getSingleResult();
		}
		catch (NoResultException e){
			return null;
		}
	}
	
}
