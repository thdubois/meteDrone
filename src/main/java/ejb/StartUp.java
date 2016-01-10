package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import remote.UserEJBRemote;

@Startup
@Singleton
public class StartUp {
	
	@EJB
	private UserEJBRemote userEJB;
	
	@PostConstruct
	public void init(){
		userEJB.initializeUsers();
	}
}
