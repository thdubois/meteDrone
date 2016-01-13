package ejb;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import remote.NumericDataEJBRemote;
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
}
