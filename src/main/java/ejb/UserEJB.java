package ejb;


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

import remote.UserEJBRemote;
import local.UserEJBLocal;
import entity.Company;
import entity.User;

@Stateless
public class UserEJB implements UserEJBLocal, UserEJBRemote{
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	@Inject
	private PartitionManager partitionManager;
	
	@Inject 
	private IdentityManager identityManager;
	
	@Override
	public void createUser(org.picketlink.idm.model.basic.User user, Long idCompany, String password){
		User userEntity = new User(user.getEmail());
		Company company = em.find(Company.class, idCompany);
		userEntity.setCompany(company);
	
		user.setLoginName(user.getEmail());
		identityManager.add(user);
		identityManager.updateCredential(user, new Password(password));
		
		org.picketlink.idm.model.basic.Role admin = BasicModel.getRole(identityManager, "administrateur");
		RelationshipManager relationshipManager = partitionManager.createRelationshipManager();
		BasicModel.grantRole(relationshipManager, user, admin);
		
		em.persist(userEntity);
	}

	@Override
	public Company findCompany(String mail) {
		TypedQuery<Company> query = em.createNamedQuery("findCompany", Company.class).setParameter("mail",mail);
		return query.getSingleResult();
	}
}
