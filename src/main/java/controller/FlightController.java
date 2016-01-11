package controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import remote.FlightEJBRemote;
import entity.Drone;
import entity.Flight;

@Named
@RequestScoped
public class FlightController implements Serializable{
	private static final long serialVersionUID = -3172135803741653900L;
	
	@EJB
	private FlightEJBRemote flightEJB;
	
	private List<Flight> flights;
	
	private List<Flight> flightsId;
 	
	private Date date = new Date();
	private String beginHour;
	private String endHour;
	
	public void addFlightToDrone(Long idDrone) throws ParseException{
		flightEJB.createFlight(date, idDrone, beginHour, endHour);
	}
	
	public List<Flight> getFlights(){
		return flightEJB.findFlights();
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public List<Flight> getFlightsId(Long id) {
		return flightEJB.findFlightsById(id);
	}

	public void setFlightsId(List<Flight> flightsId) {
		this.flightsId = flightsId;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBeginHour() {
		return beginHour;
	}

	public void setBeginHour(String beginHour) {
		this.beginHour = beginHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	
}
