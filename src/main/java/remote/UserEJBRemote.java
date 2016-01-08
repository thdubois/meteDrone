package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.User;
import entity.Company;

@Remote
public interface UserEJBRemote {
	public void createUser(org.picketlink.idm.model.basic.User user, Long company, String role, String password);
	public Company findCompany(String mail);
	public void deleteUser(User user);
	public List<User> findUsers();
	public User findUserById();
	public User findUserByMail(String mail);
}
