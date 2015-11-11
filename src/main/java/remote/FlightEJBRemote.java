package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.Flight;

@Remote
public interface FlightEJBRemote {
	public List<Flight> findFlights();
}
