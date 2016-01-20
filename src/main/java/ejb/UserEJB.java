package ejb;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.Role;

import remote.CompanyEJBRemote;
import remote.UserEJBRemote;
import local.UserEJBLocal;
import entity.Company;
import entity.User;

@Stateless
public class UserEJB implements UserEJBLocal, UserEJBRemote, Serializable{
	
	private static final long serialVersionUID = 5880562677330473861L;

	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	@Inject
	private PartitionManager partitionManager;
	
	@Inject 
	private IdentityManager identityManager;
	
	@EJB
	private CompanyEJBRemote companyEJB;
	
	@Override
	public void createUser(org.picketlink.idm.model.basic.User user, String companyName, String role, String password) throws Exception{
		
		User userEntity = new User(user.getEmail());
		Company company = companyEJB.findCompanyByName(companyName);
		if (company==null){
			company=companyEJB.createCompany(companyName);
		}
		userEntity.setCompany(company);
		em.persist(userEntity);

		user.setLoginName(user.getEmail());
		identityManager.add(user);
		identityManager.updateCredential(user, new Password(password));
	
		Role rolePicket = BasicModel.getRole(identityManager, role);
		RelationshipManager relationshipManager = partitionManager.createRelationshipManager();
		BasicModel.grantRole(relationshipManager, user, rolePicket);
		
	}
	
	public void createSuperUsers(User user){
		em.persist(user);
	}

	@Override
	public Company findCompany(String email) {
		TypedQuery<Company> query = em.createNamedQuery("findCompany", Company.class).setParameter("mail",email);
		return query.getSingleResult();
	}
	
	public List<User> findUserByCompany(Long companyId) {
		TypedQuery<User> query = em.createNamedQuery("findUserByCompany", User.class).setParameter("companyId",companyId).setParameter("companyId",companyId);
		return query.getResultList();
	}
	
	@Override
	public List<User> findUsers() {
		TypedQuery<User> query = em.createNamedQuery("findUsers", User.class);
		return query.getResultList();
	}
	
	@Override
	public User findUserByMail(String mail) {
		TypedQuery<User> query = em.createNamedQuery("findUserByMail", User.class).setParameter("mail", mail);
		return query.getSingleResult();
	}
	
	@Override
	public void deleteCompany(User user){
		user.setCompany(null);
		em.merge(user);
	}
	
	@Override
	public void deleteUser(User user){
		em.remove(user);
	}
	
	@Override
	public void	initializeUsers(){
		Company company=new Company();
		company.setName("meteDrone");
		em.persist(company);

		User user=new User();
		user.setEmail("admin");
		user.setCompany(company);
		em.persist(user);
		
		User user2=new User();
		user2.setEmail("olivier.kastel@gmail.com");
		user2.setCompany(company);
		em.persist(user2);
		
		User user3=new User();
		user3.setEmail("benjamin.bost@gmail.com");
		user3.setCompany(company);
		em.persist(user3);
	}

}
