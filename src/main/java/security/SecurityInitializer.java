package security;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;

@Singleton
@Startup
public class SecurityInitializer{

	@Inject
	private PartitionManager partitionManager;

	
	@PostConstruct
	public void create() {
		IdentityManager identityManager = this.partitionManager
				.createIdentityManager();
		User user = new User("admin");
		user.setFirstName("Stephanie");
		user.setLastName("Chollet");
		user.setEmail("stephanie.chollet@esisar.com");
		identityManager.add(user);
		identityManager.updateCredential(user, new Password("admin"));

		Role admin = new Role("administrateur");
		identityManager.add(admin);
		RelationshipManager relationshipManager = partitionManager.createRelationshipManager();
		BasicModel.grantRole(relationshipManager, user, admin);
		
		Role pilote = new Role("pilote");
		identityManager.add(pilote);
		
		}
}