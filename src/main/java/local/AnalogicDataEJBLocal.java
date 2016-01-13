package local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entity.AnalogicData;

@Local
public interface AnalogicDataEJBLocal {
	public void createAnalogicData(Date date, Double value, Long analogicId);
	public List<AnalogicData> findAnalogicData(Long sensorId);
}
