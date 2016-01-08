package local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entity.Drone;
import entity.Sensor;

@Local
public interface SensorEJBLocal {
	public List<Sensor> findSensorsById(Long id);
	public List<Sensor> findSensors();
	public void deleteSensor(Long sensorId);
	public void createSensor(int type, String name, String model, Date inServiceDate, Float price, Drone drone);
}