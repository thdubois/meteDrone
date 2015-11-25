package local;

import javax.ejb.Local;

import org.picketlink.idm.model.basic.User;

import entity.Company;

@Local
	public interface UserEJBLocal {
		public void createUser(User user, Long company, String password);
		public Company findCompany(String mail);
	}

