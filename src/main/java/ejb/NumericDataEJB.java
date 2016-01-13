package ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import remote.NumericDataEJBRemote;
import entity.AnalogicData;
import entity.Numeric;
import entity.NumericData;
import local.NumericDataEJBLocal;

@Stateless
public class NumericDataEJB implements NumericDataEJBRemote, NumericDataEJBLocal{

	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public void createNumericData(Date date, Boolean value, Long numericId) {
		NumericData numericData = new NumericData();
		numericData.setDate(date);
		numericData.setValue(value);
		Numeric numeric = em.find(Numeric.class, numericId);
		numericData.setNumeric(numeric);
		em.persist(numericData);
	}
	
	@Override
	public List<NumericData> findNumericData(Long sensorId) {
		TypedQuery<NumericData> query=em.createNamedQuery("findNumericData",NumericData.class).setParameter("sensorId", sensorId);
		return query.getResultList();
	}
}
