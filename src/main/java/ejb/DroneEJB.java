package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import local.DroneEJBLocal;
import remote.DroneEJBRemote;
import entity.Drone;
import entity.Flight;
import entity.Sensor;

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
		droneEntity.setStatus("Fonctionnel");
		em.persist(droneEntity);	
	}
	
	public void deleteDrone(Long droneId){
		TypedQuery<Sensor> query=em.createNamedQuery("findSensorsById",Sensor.class).setParameter("droneId", droneId);
		List<Sensor> sensors=query.getResultList();
		for (Sensor s: sensors){
			s.setDrone(null);
			em.persist(s);
		}
		Drone drone=em.find(Drone.class, droneId);
		em.remove(drone);
	}
	
}