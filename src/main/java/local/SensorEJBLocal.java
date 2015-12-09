package local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entity.Sensor;

@Local
public interface SensorEJBLocal {
	public List<Sensor> findSensorsById(Long id);
	public List<Sensor> findSensors();
	public void createSensor(int type, String name, String model, Date inServiceDate, Float price, Long idDrone);
}