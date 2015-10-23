package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import remote.FlightEJBRemote;
import ejb.FlightEJB;
import entity.Flight;

@Named
@RequestScoped
public class FlightController implements Serializable{
	private static final long serialVersionUID = -3172135803741653900L;
	
	@EJB
	private FlightEJBRemote flightEJB;
	
	private List<Flight> flights; 
	
	private int duration;
	
	@PostConstruct
	public void init() {
		duration = 10;
	}
	
	public List<Flight> getFlights(){
		return flightEJB.findFlights();
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
