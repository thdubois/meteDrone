package controller;

import java.util.List;

import javax.ejb.EJB;

import ejb.FlightEJB;
import entity.Flight;

public class FlightController {
	@EJB
	private FlightEJB flightEJB;
	
	public List<Flight> findFlights(){
		return flightEJB.findFlights();
	}
}
