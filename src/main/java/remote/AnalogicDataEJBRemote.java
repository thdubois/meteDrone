package remote;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface AnalogicDataEJBRemote {
	public void createAnalogicData(Date date, Double value, Long numericId);
}
