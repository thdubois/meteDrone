package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import remote.AnalogicEJBRemote;
import entity.Analogic;


@Stateless
public class AnalogicEJB implements AnalogicEJBRemote {
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public List<Analogic> findAnalogics() {
		TypedQuery<Analogic> query=em.createNamedQuery("findAnalogics",Analogic.class);
		return query.getResultList();
	}	
	
	@Override
	public Analogic findAnalogic(Long sensorId) {
		TypedQuery<Analogic> query=em.createNamedQuery("findAnalogic",Analogic.class).setParameter("sensorId", sensorId);
		return query.getSingleResult();
	}
}
