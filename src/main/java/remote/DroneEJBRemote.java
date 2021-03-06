package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.Drone;
import entity.Flight;

@Remote
public interface DroneEJBRemote {
	public List<Flight> findFlightsById(Long id);
	public List<Drone> findDrones();
	public void createDrone(String model, String name, String city);
	public void deleteDrone(Long droneId);
}
