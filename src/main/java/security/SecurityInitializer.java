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
		
		User user2= new User("toto");
		user2.setFirstName("Thomas");
		user2.setLastName("Dudu");
		user2.setEmail("toto");
		identityManager.add(user2);
		identityManager.updateCredential(user2, new Password("toto"));
		
		User user3= new User("jeje");
		user3.setFirstName("Jeremy");
		user3.setLastName("Bancker");
		user3.setEmail("jeje");
		identityManager.add(user3);
		identityManager.updateCredential(user3, new Password("jeje"));

		Role admin = new Role("administrateur");
		identityManager.add(admin);
		RelationshipManager relationshipManager = partitionManager.createRelationshipManager();
		BasicModel.grantRole(relationshipManager, user, admin);
		
		Role pilote = new Role("pilote");
		identityManager.add(pilote);
		BasicModel.grantRole(relationshipManager, user2, pilote);
		
		Role meteorologue = new Role("meteorologue");
		identityManager.add(meteorologue);
		BasicModel.grantRole(relationshipManager, user3, meteorologue);
		
		}
}