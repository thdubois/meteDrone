package controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import remote.AnalogicEJBRemote;
import remote.NumericEJBRemote;
import remote.SensorEJBRemote;
import entity.Analogic;
import entity.Numeric;
import entity.Sensor;

@Named
@SessionScoped
public class SingleSensorController implements Serializable{
	
	private static final long serialVersionUID = -2578391305904452076L;

	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	@EJB
	private SensorEJBRemote sensorEJB;
	
	@EJB
	private NumericEJBRemote numericEJB;
	
	@EJB
	private AnalogicEJBRemote analogicEJB;
	
	private Sensor sensor;
	
	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public String initializeSensor(Long sensorId){
		setSensor(em.find(Sensor.class, sensorId));
		
		if(em.find(Analogic.class, sensorId) != null){			
			return "analogic";
		}
		else if(em.find(Numeric.class, sensorId) != null){
			return "numeric";
		}
		else{
			return "sensor";
		}
	}
	
	public void deleteSensor(Long sensorId){
		sensorEJB.deleteSensor(sensorId);
	}
	
}
