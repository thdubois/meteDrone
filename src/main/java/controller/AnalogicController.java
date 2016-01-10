package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entity.Analogic;
import remote.AnalogicEJBRemote;

@Named
@RequestScoped
public class AnalogicController implements Serializable{

	private static final long serialVersionUID = -3383534431558113811L;

	@EJB
	AnalogicEJBRemote analogicEJB;
	
	List<Analogic> analogics;

	public List<Analogic> getAnalogics() {
		return analogicEJB.findAnalogics();
	}

	public void setAnalogics(List<Analogic> analogics) {
		this.analogics = analogics;
	}	

}
