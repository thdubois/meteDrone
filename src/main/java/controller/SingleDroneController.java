package controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Drone;
import remote.FlightEJBRemote;

@Named
@SessionScoped
public class SingleDroneController implements Serializable{
	
	private static final long serialVersionUID = -2578391305904452076L;

	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	@EJB
	private FlightEJBRemote flightEJB;
	
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
}
