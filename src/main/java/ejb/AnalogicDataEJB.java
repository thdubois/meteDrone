package ejb;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import remote.AnalogicDataEJBRemote;
import entity.Analogic;
import entity.AnalogicData;
import local.AnalogicDataEJBLocal;

@Stateless
public class AnalogicDataEJB implements AnalogicDataEJBRemote, AnalogicDataEJBLocal{

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
}
