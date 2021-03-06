package ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import remote.NumericEJBRemote;
import entity.Numeric;


@Stateless
public class NumericEJB implements NumericEJBRemote, Serializable {
	
	private static final long serialVersionUID = 5565633571739798364L;
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public List<Numeric> findNumerics() {
		TypedQuery<Numeric> query=em.createNamedQuery("findNumerics",Numeric.class);
		return query.getResultList();
	}
	
	@Override
	public Numeric findNumeric(Long sensorId) {
		TypedQuery<Numeric> query=em.createNamedQuery("findNumeric",Numeric.class).setParameter("sensorId", sensorId);
		return query.getSingleResult();
	}
}
