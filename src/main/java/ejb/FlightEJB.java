package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import FlightEJBLocal.FlightEJBLocal;
import remote.FlightEJBRemote;
import entity.Flight;

@Stateless
public class FlightEJB implements FlightEJBRemote, FlightEJBLocal {
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	public List<Flight> findFlights(){
		TypedQuery<Flight> query=em.createQuery("SELECT f FROM Flight f",Flight.class);
		return query.getResultList();		
	}

}
