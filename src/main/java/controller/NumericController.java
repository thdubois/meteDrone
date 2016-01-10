package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entity.Numeric;
import remote.NumericEJBRemote;

@Named
@RequestScoped
public class NumericController implements Serializable{

	private static final long serialVersionUID = 2127925738656465800L;
	
	@EJB
	NumericEJBRemote numericEJB;
	
	List<Numeric> numerics;

	public List<Numeric> getNumerics() {
		return numericEJB.findNumerics();
	}

	public void setNumerics(List<Numeric> numerics) {
		this.numerics = numerics;
	}	

}
