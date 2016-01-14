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

	private static final long serialVersionUID = 1L;
	@EJB
	private DroneEJBRemote droneEJB;
	private List<Drone> drones;

	private String model;
	private String name;
	private String city;

	public void addDrone(){
		droneEJB.createDrone(name, model, city);
	}

	public void deleteDrone(Long droneId){
		droneEJB.deleteDrone(droneId);
	}

	public List<Drone> getDrones() {
		return droneEJB.findDrones();
	}

	public void setDrones(List<Drone> drones) {
		this.drones = drones;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
