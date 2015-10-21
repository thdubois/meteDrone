package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import remote.FlightEJBRemote;
import entity.Flight;

@Stateless
public class FlightEJB implements FlightEJBRemote {
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	public List<Flight> findFlights(){
		TypedQuery<Flight> query=em.createNamedQuery("findFlights",Flight.class);
		return query.getResultList();		
	}

}
