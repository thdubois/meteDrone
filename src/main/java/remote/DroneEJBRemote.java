package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.Flight;

@Remote
public interface DroneEJBRemote {
	public List<Flight> findFlightsById(Long id);
}
