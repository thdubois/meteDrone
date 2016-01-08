package controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Drone;
import remote.FlightEJBRemote;
import remote.SensorEJBRemote;

@Named
@SessionScoped
public class SingleDroneController implements Serializable{
	
	private static final long serialVersionUID = -2578391305904452076L;

	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	@EJB
	private FlightEJBRemote flightEJB;
	@EJB
	private SensorEJBRemote sensorEJB;
	
	private Drone drone;
	
	public String initializeDrone(Long id){
		setDrone(em.find(Drone.class, id));
		return "initSuccess";
	}
	
	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	
	public void deleteSensor(Long sensorId){
		sensorEJB.deleteSensor(sensorId);
	}
	
	public void deleteFlight(Long flightId){
		flightEJB.deleteFlight(flightId);
	}
}
