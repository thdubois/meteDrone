package remote;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entity.AnalogicData;

@Remote
public interface AnalogicDataEJBRemote {
	public void createAnalogicData(Date date, Double value, Long numericId);
	public List<AnalogicData> findAnalogicData(Long sensorId);
}
