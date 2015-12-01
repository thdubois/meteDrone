package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entity.Drone;
import remote.DroneEJBRemote;


@Named
@RequestScoped
public class DroneController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private DroneEJBRemote droneEJB;
	private List<Drone> drones;
	
	public List<Drone> getDrones() {
		return droneEJB.findDrones();
	}
	public void setDrones(List<Drone> drones) {
		this.drones = drones;
	}
	

	
	

}
