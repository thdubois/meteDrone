package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import remote.AnalogicDataEJBRemote;
import entity.AnalogicData;;

@Named
@RequestScoped
public class AnalogicDataController implements Serializable{
	
	private static final long serialVersionUID = 8294710654309833073L;
	
	@EJB
	AnalogicDataEJBRemote analogicData;
	
	public List<AnalogicData> findAnalogicData(Long sensorId){
		return analogicData.findAnalogicData(sensorId);
	}
}
