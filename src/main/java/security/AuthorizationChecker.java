
package security;

import org.apache.log4j.Logger;
import org.picketlink.Identity;
import org.picketlink.idm.IdentityManagementException;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.Group;
import org.picketlink.idm.model.basic.Role;

import controller.VilleController;

import javax.inject.Inject;
import javax.inject.Named;

import static org.picketlink.idm.model.basic.BasicModel.*;

@Named 
public class AuthorizationChecker {
    
    @Inject
    private Identity identity;
    
    @Inject 
    private IdentityManager identityManager;

    @Inject
    private RelationshipManager relationshipManager;

	private final static Logger logger = Logger.getLogger(AuthorizationChecker.class);

    public boolean hasApplicationRole(String roleName) {
    	try{
        Role role = getRole(this.identityManager, roleName);
        return hasRole(this.relationshipManager, this.identity.getAccount(), role);
    	}
    	catch(IdentityManagementException i){
    		logger.info(i);
    		return false;
    	}
    }

    public boolean isMember(String groupName) {
        Group group = getGroup(this.identityManager, groupName);
        return BasicModel.isMember(this.relationshipManager, this.identity.getAccount(), group);
    }

    public boolean hasGroupRole(String roleName, String groupName) {
        Group group = getGroup(this.identityManager, groupName);
        Role role = getRole(this.identityManager, roleName);
        return BasicModel.hasGroupRole(this.relationshipManager, this.identity.getAccount(), role, group);
    }
}