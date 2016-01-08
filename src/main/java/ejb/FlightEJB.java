package ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import local.FlightEJBLocal;
import remote.FlightEJBRemote;
import entity.Drone;
import entity.Flight;

@Stateless
public class FlightEJB implements FlightEJBRemote, FlightEJBLocal {
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public List<Flight> findFlights() {
		TypedQuery<Flight> query=em.createNamedQuery("findFlights",Flight.class);
		return query.getResultList();
	}
	
	public List<Flight> findFlightsById(Long id) {
		TypedQuery<Flight> query=em.createNamedQuery("findFlightsById",Flight.class).setParameter("idDrone", id);
		return query.getResultList();
	}
	
	public void createFlight(Date date, Long duration, Long idDrone){
		Flight flightEntity = new Flight();
		flightEntity.setDate(date);
		flightEntity.setDuration(duration);
		Drone drone=em.find(Drone.class, idDrone);
		flightEntity.setDrone(drone);
		em.persist(flightEntity);	
	}
	
	public void deleteFlight(Long flightId){
		Flight flight=em.find(Flight.class, flightId);
		em.remove(flight);
	}
}
