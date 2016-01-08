package local;

import java.util.List;

import javax.ejb.Local;

import entity.User;
import entity.Company;

@Local
public interface UserEJBLocal {
	public void createUser(org.picketlink.idm.model.basic.User user, Long company, String role, String password);
	public Company findCompany(String mail);
	public void deleteUser(User user);
	public List<User> findUsers();
	public User findUserById();
	public Long findUserByMail(String mail);
}

