package local;

import java.util.List;

import javax.ejb.Local;

import entity.Drone;
import entity.Flight;

@Local
public interface DroneEJBLocal {
	public List<Flight> findFlightsById(Long id);
	public List<Drone> findDrones();
	public void createDrone(String model, String name, String city);
}
