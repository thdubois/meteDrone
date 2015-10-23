package FlightEJBLocal;

import java.util.List;
import javax.ejb.Local;
import entity.Flight;

@Local
public interface FlightEJBLocal {
	public List<Flight> findFlights();
}
