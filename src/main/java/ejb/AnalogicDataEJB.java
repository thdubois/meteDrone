package ejb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import remote.AnalogicDataEJBRemote;
import entity.Analogic;
import entity.AnalogicData;
import local.AnalogicDataEJBLocal;

@Stateless
public class AnalogicDataEJB implements AnalogicDataEJBRemote, AnalogicDataEJBLocal, Serializable{

	private static final long serialVersionUID = 2857022034617087845L;
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public void createAnalogicData(Date date, Double value, Long analogicId) {
		AnalogicData analogicData = new AnalogicData();
		analogicData.setDate(date);
		analogicData.setValue(value);
		Analogic analogic = em.find(Analogic.class, analogicId);
		analogicData.setAnalogic(analogic);
		em.persist(analogicData);
	}
	
	@Override
	public List<AnalogicData> findAnalogicData(Long sensorId) {
		TypedQuery<AnalogicData> query=em.createNamedQuery("findAnalogicData",AnalogicData.class).setParameter("sensorId", sensorId);
		return query.getResultList();
	}
}
