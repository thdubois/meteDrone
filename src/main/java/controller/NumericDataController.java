package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import remote.NumericDataEJBRemote;
import entity.NumericData;

@Named
@RequestScoped
public class NumericDataController implements Serializable{
	
	private static final long serialVersionUID = 8294710654309833073L;
	
	@EJB
	NumericDataEJBRemote numericData;
	
	public List<NumericData> findNumericData(Long sensorId){
		return numericData.findNumericData(sensorId);
	}
}
