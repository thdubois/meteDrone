package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;



@RequestScoped @Named
public class LoginController {

	@Inject Identity identity;
	private Boolean status = false;

	public void login() {
		AuthenticationResult result = identity.login();
		if (AuthenticationResult.FAILED.equals(result)) {
			setStatus(true);
		}
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}