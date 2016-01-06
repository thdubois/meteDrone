package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.SensorEJB;
import entity.Sensor;

@Named
@SessionScoped
public class SingleSensorController implements Serializable{
	
	private static final long serialVersionUID = -2578391305904452076L;

	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	private SensorEJB sensorEJB;
	
	private Sensor sensor;
	
	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public String initializeSensor(Long id){
		setSensor(em.find(Sensor.class, id));
		return "initSuccess";
	}
	
	public void deleteSensor(Long id){
		//initializeSensor(id);
		sensorEJB.deleteSensor(id);
	}
	
}
