package remote;

import javax.ejb.Remote;

import org.picketlink.idm.model.basic.User;

import entity.Company;

@Remote
public interface UserEJBRemote {
	public void createUser(User user, Long company, String password);
	public Company findCompany(String mail);
}
