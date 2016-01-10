package local;

import java.util.List;

import javax.ejb.Local;

import entity.User;
import entity.Company;

@Local
public interface UserEJBLocal {
	public void	initializeUsers();
	public void createUser(org.picketlink.idm.model.basic.User user, String companyName, String role, String password);
	public void deleteUser(User user);
	public void deleteCompany(User user);
	public Company findCompany(String email);
	public List<User> findUsers();
	public User findUserByMail(String mail);
	public List<User> findUserByCompany(Long companyId);
}

