package local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entity.Flight;

@Local
public interface FlightEJBLocal {
	public List<Flight> findFlights();
	public List<Flight> findFlightsById(Long id);
	public void createFlight(Date date, Long idDrone, String beginHour, String endHour);
	public void deleteFlight(Long flightId);
}
