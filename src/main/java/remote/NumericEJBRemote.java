package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.Numeric;

@Remote
public interface NumericEJBRemote {
	public List<Numeric> findNumerics();
	public Numeric findNumeric(Long sensorId);
}