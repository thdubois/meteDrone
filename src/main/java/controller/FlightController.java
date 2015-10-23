package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ejb.FlightEJB;
import entity.Flight;

@ManagedBean
public class FlightController implements Serializable{
	private static final long serialVersionUID = -3172135803741653900L;
	
	@EJB
	private FlightEJB flightEJB;
	
	private List<Flight> flights; 
	
	public List<Flight> getFlights(){
		return flightEJB.findFlights();
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	private int duration =10;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
