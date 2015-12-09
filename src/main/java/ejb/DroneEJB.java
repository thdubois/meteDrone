package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import local.DroneEJBLocal;
import remote.DroneEJBRemote;
import entity.Company;
import entity.Drone;
import entity.Flight;
import entity.User;

@Stateless
public class DroneEJB implements DroneEJBRemote, DroneEJBLocal {
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public List<Flight> findFlightsById(Long id) {
		TypedQuery<Flight> query=em.createNamedQuery("findFlightById",Flight.class).setParameter("idDrone", id);
		return query.getResultList();
	}
	
	@Override
	public List<Drone> findDrones() {
		TypedQuery<Drone> query=em.createNamedQuery("findDrones",Drone.class);
		return query.getResultList();
	}
	
	public void createDrone(String name, String model, String city){
		Drone droneEntity = new Drone();
		droneEntity.setModel(model);
		droneEntity.setName(name);
		droneEntity.setCity(city);
		em.persist(droneEntity);	
	}
	
}
