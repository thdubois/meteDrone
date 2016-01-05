package controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entity.Sensor;
import entity.Suscription;
import remote.SuscriptionEJBRemote;

@Named
@RequestScoped
public class SuscriptionController implements Serializable{

	private static final long serialVersionUID = 424193175379048984L;
	@EJB
	private SuscriptionEJBRemote suscriptionEJB;
	private List<Suscription> suscriptions;
	
	private List<Sensor> sensorsUser;

	private String idUser;	
	private String idSensor;
	private String dateBegin;
	
	public void addSuscription() throws ParseException{
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = dt.parse(dateBegin); 
		suscriptionEJB.createSuscription(date, Long.parseLong(idUser), Long.parseLong(idSensor));
	}
		
	public List<Sensor> getSensorsUser(Long idUser) {
		return suscriptionEJB.findSensorsUserById(idUser);
	}

	public void setSensorsUser(List<Sensor> sensorsUser) {
		this.sensorsUser = sensorsUser;
	}

	public List<Suscription> getSuscriptionById(Long id){
		return suscriptionEJB.findSuscriptionById(id);
	}
	
	public List<Suscription> getSuscriptions(){
		return suscriptionEJB.findSuscriptions();
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getIdSensor() {
		return idSensor;
	}

	public void setIdSensor(String idSensor) {
		this.idSensor = idSensor;
	}

	public String getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}
	
}
