package remote;

import java.util.List;
import entity.Flight;

public interface FlightEJBRemote {
	public List<Flight> findFlights();
}
