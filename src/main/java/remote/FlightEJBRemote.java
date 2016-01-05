package remote;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entity.Drone;
import entity.Flight;

@Remote
public interface FlightEJBRemote {
	public List<Flight> findFlights();
	public List<Flight> findFlightsById(Long id);
	public void createFlight(Date date, Long duration, Long idDrone);

}
