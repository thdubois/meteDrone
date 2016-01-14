package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.User;
import entity.Company;

@Remote
public interface UserEJBRemote {
	public void	initializeUsers();
	public void createUser(org.picketlink.idm.model.basic.User user, String companyName, String role, String password) throws Exception;
	public void deleteUser(User user);
	public void deleteCompany(User user);
	public Company findCompany(String email);
	public List<User> findUsers();
	public User findUserByMail(String mail);
	public List<User> findUserByCompany(Long companyId);
}
