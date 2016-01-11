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
import remote.SensorEJBRemote;
import remote.SuscriptionEJBRemote;
import remote.UserEJBRemote;

@Named
@RequestScoped
public class SuscriptionController implements Serializable{

	private static final long serialVersionUID = 424193175379048984L;
	
	@EJB
	private SuscriptionEJBRemote suscriptionEJB;
	@EJB
	private SensorEJBRemote sensorEJB;
	
	@EJB
	private UserEJBRemote userEJB;
		
	private String idSensor;
	private Date dateBegin = new Date();
	
	public void addSuscription(String mail) throws ParseException{
		suscriptionEJB.createSuscription(dateBegin, userEJB.findUserByMail(mail).getId(), Long.parseLong(idSensor));
	}
	
	public List <Sensor> findDroneSensors(){
		return sensorEJB.findDroneSensors();
	}
	
	
	public void deleteSuscription(Long suscriptId){
		suscriptionEJB.deleteSuscription(suscriptId);
	}
	
	public List<Suscription> findSuscriptionsUser(String email) {
		return suscriptionEJB.findSuscriptionsUserById(email);
	}
	
	public List<Suscription> getSuscriptions(){
		return suscriptionEJB.findSuscriptions();
	}

	public String getIdSensor() {
		return idSensor;
	}

	public void setIdSensor(String idSensor) {
		this.idSensor = idSensor;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	
}
