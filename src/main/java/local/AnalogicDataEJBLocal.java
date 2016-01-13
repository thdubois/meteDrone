package local;

import java.util.Date;

import javax.ejb.Local;

@Local
public interface AnalogicDataEJBLocal {
	public void createAnalogicData(Date date, Double value, Long analogicId);
}
