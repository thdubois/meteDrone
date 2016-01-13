package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.Analogic;

@Remote
public interface AnalogicEJBRemote {
	public List<Analogic> findAnalogics();
	public Analogic findAnalogic(Long sensorId);
}
