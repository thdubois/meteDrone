package remote;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entity.NumericData;

@Remote
public interface NumericDataEJBRemote {
	public void createNumericData(Date date, Boolean value, Long numericId);
	public List<NumericData> findNumericData(Long sensorId);
}
