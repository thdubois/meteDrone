package controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entity.Drone;
import entity.Sensor;
import remote.SensorEJBRemote;

@Named
@RequestScoped
public class SensorController implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private SensorEJBRemote sensorEJB;
	private List<Sensor> sensors;

	private String name;	
	private String model;
	private String inServiceDate;
	private String price;
	private String idDrone;
	private String typeSensor;
		
	public void addSensorToDrone(Drone drone) throws ParseException{
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = dt.parse(inServiceDate); 
		sensorEJB.createSensor(Integer.parseInt(typeSensor), name, model, date, Float.parseFloat(price), drone);
	}
	
	public void deleteSensor(Sensor sensor){
		
	}
	
	public List<Sensor> getSensorsById(Long id){
		return sensorEJB.findSensorsById(id);
	}
	
	public List<Sensor> getSensors(){
		return sensorEJB.findSensors();
	}
	
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public SensorEJBRemote getSensorEJB() {
		return sensorEJB;
	}

	public void setSensorEJB(SensorEJBRemote sensorEJB) {
		this.sensorEJB = sensorEJB;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInServiceDate() {
		return inServiceDate;
	}

	public void setInServiceDate(String inServiceDate) {
		this.inServiceDate = inServiceDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(String idDrone) {
		this.idDrone = idDrone;
	}

	public String getTypeSensor() {
		return typeSensor;
	}

	public void setTypeSensor(String typeSensor) {
		this.typeSensor = typeSensor;
	}
	
	
}
