package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import local.DroneEJBLocal;
import local.FlightEJBLocal;
import remote.DroneEJBRemote;
import remote.FlightEJBRemote;
import entity.Flight;

@Stateless
public class DroneEJB implements DroneEJBRemote, DroneEJBLocal {
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public List<Flight> findFlightsById(Long id) {
		TypedQuery<Flight> query=em.createNamedQuery("findFlightById",Flight.class).setParameter("idDrone", id);
		return query.getResultList();
	}
	

}
