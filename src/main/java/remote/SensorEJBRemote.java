package remote;

import java.util.Date;
import java.util.List;

import entity.Drone;

import javax.ejb.Local;

import entity.Sensor;

@Local
public interface SensorEJBRemote {
	public List<Sensor> findSensorsById(Long id);
	public List<Sensor> findSensors();
	public void deleteSensor(Long sensorId);
	public void createSensor(int type, String name, String model, Date inServiceDate, Float price, Drone drone);
	public List<Sensor> findDroneSensors();
}
