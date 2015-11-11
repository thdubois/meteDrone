package local;

import java.util.List;
import javax.ejb.Local;
import entity.Flight;

@Local
public interface DroneEJBLocal {
	public List<Flight> findFlightsById(Long id);
}
